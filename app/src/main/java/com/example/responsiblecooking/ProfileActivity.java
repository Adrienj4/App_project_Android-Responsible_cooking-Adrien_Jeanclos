package com.example.responsiblecooking;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.OnClick;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.responsiblecooking.adapters.UserHelper;
import com.example.responsiblecooking.base.BaseActivity;
import com.example.responsiblecooking.base.BaseFragment;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileActivity extends BaseActivity {

    FirebaseUser user;

    @BindView(R.id.profile_activity_progress_bar)
    ProgressBar progressBar;

    // Creating identifier to identify REST REQUEST
    private static final int SIGN_OUT_TASK = 10;
    private static final int DELETE_USER_TASK = 20;
    private static final int UPDATE_USERNAME = 30;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

    }
    /*
    // --------------------
    // ACTIONS
    // --------------------

    @OnClick(R.id.buttonSave)
    public void onClickUpdateButton() { this.updateUsernameInFirebase(); }

    // --------------------
    // REST REQUESTS
    // --------------------

    private void updateUsernameInFirebase(){

        user = FirebaseAuth.getInstance().getCurrentUser();

        EditText editTextUserName = (EditText)findViewById(R.id.editTextUsername);

        String username = editTextUserName.getText().toString();

        if (user != null){
            if (!username.isEmpty() &&  !username.equals(getString(R.string.info_no_username_found))){
                UserHelper.updateUserName(username, user.getUid()).addOnFailureListener(this.onFailureListener()).addOnSuccessListener(this.updateUIAfterRESTRequestsCompleted(UPDATE_USERNAME));
            }
        }
    }

    // --------------------
    // UI
    // --------------------

    private OnSuccessListener<Void> updateUIAfterRESTRequestsCompleted(final int origin){
        return new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                switch (origin){
                    case UPDATE_USERNAME:
                        progressBar.setVisibility(View.INVISIBLE);
                        break;
                    case SIGN_OUT_TASK:
                        finish();
                        break;
                    case DELETE_USER_TASK:
                        finish();
                        break;
                    default:
                        break;
                }
            }
        };
    }

    public void ReturnHome(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        view.getContext().startActivity(intent);
    }
     */
}
