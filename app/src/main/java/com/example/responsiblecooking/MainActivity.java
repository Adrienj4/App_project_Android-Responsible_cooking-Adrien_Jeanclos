package com.example.responsiblecooking;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.responsiblecooking.adapters.UserHelper;
import com.example.responsiblecooking.base.BaseActivity;
import com.example.responsiblecooking.ui.home.HomeFragment;
import com.example.responsiblecooking.ui.profile.ProfileFragment;
import com.example.responsiblecooking.ui.recipes.RecipesFragment;
import com.example.responsiblecooking.ui.search.SearchFragment;
import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.ErrorCodes;
import com.firebase.ui.auth.IdpResponse;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Arrays;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by <Adrien JEANCLOS> on <DATE-DU-JOUR> source https://openclassrooms.com/fr/
 */

public class MainActivity extends BaseActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    //For design
    @BindView(R.id.main_activity_coordinator_layout)
    RelativeLayout relativeLayout;
    @BindView(R.id.bottom_navigation)
    BottomNavigationView bottomNavigationView;
    @BindView(R.id.floatingActionButtonAdd)
    FloatingActionButton fabAdd;
    @BindView(R.id.floatingActionButtonEdit)
    FloatingActionButton fabEdit;

    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this); //Configure Butterknife

        //Login with firebase
        user = FirebaseAuth.getInstance().getCurrentUser();

        if(user == null){
            createSignInIntent();
        }else {
            loadFragment(new HomeFragment());
            fabEdit.hide();
            Toast.makeText(getApplicationContext(),
                    "Welcome " + user.getDisplayName(),
                    Toast.LENGTH_SHORT).show();
            //Getting bottom navigation view and attaching the listener
            BottomNavigationView navView = findViewById(R.id.bottom_navigation);
            bottomNavigationView.setOnNavigationItemSelectedListener(this);
        }

        // Add recipe - Floating Button
        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), AddRecipeActivity.class);
                view.getContext().startActivity(intent);
            }
        });

        // Edit profile - Floating Button
        fabEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ProfileActivity.class);
                view.getContext().startActivity(intent);
            }
        });
    }

    // Bottom navigation view and switch fragment

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        switch (item.getItemId()) {
            case R.id.navigation_home:
                fragment = new HomeFragment();
                fabAdd.show();
                fabEdit.hide();
                break;
            case R.id.navigation_search:
                fragment = new SearchFragment();
                fabAdd.hide();
                fabEdit.hide();
                break;
            case R.id.navigation_profile:
                fragment = new ProfileFragment();
                fabAdd.hide();
                fabEdit.show();
                break;
            case R.id.navigation_recipes:
                fragment = new RecipesFragment();
                fabAdd.hide();
                fabEdit.hide();
                break;
        }

        return loadFragment(fragment);
    }

    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    //FOR DATA
    //Launch FirebaseUI
    private final int RC_SIGN_IN = 123;

    public void createSignInIntent() {
        List<AuthUI.IdpConfig> providers = Arrays.asList(
                new AuthUI.IdpConfig.EmailBuilder().build(),
                new AuthUI.IdpConfig.GoogleBuilder().build());

        // Create and launch sign-in intent
        startActivityForResult(
                AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setTheme(R.style.LoginTheme)
                        .setAvailableProviders(providers)
                        .setIsSmartLockEnabled(false,true)
                        .setLogo(R.drawable.ic_logo_auth)
                        .build(),
                RC_SIGN_IN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        this.handleResponseAfterSignIn(requestCode, resultCode, data);
    }

    // --------------------
    // UI
    // --------------------

    private void showSnackBar(CoordinatorLayout coordinatorLayout, String message){
        Snackbar.make(coordinatorLayout, message, Snackbar.LENGTH_SHORT).show();
    }

    // --------------------
    // REST REQUEST
    // --------------------

    // 1 - Http request that create user in firestore
    private void createUserInFirestore(){

        if (this.getCurrentUser() != null){

            String userName = this.getCurrentUser().getDisplayName();
            String uId = this.getCurrentUser().getUid();

            UserHelper.createUser(uId, userName).addOnFailureListener(this.onFailureListener());
        }
    }

    private void handleResponseAfterSignIn(int requestCode, int resultCode, Intent data){

        IdpResponse response = IdpResponse.fromResultIntent(data);

        if (requestCode == RC_SIGN_IN) {
            if (resultCode == RESULT_OK) { // SUCCESS
                this.createUserInFirestore();
                //showSnackBar(this.coordinatorLayout, getString(R.string.connection_succeed));
            } else { // ERRORS
                /*
                if (response == null) {
                    showSnackBar(this.relativeLayout, getString(R.string.error_authentication_canceled));
                } else if (response.getError().getErrorCode() == ErrorCodes.NO_NETWORK) {
                    showSnackBar(this.relativeLayout, getString(R.string.error_no_internet));
                } else if (response.getError().getErrorCode() == ErrorCodes.UNKNOWN_ERROR) {
                    showSnackBar(this.relativeLayout, getString(R.string.error_unknown_error));
                }
                 */
            }
        }
    }
}
