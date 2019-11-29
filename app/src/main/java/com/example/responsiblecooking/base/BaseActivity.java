package com.example.responsiblecooking.base;


import android.os.Bundle;
import android.widget.Toast;

import com.example.responsiblecooking.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;

/**
 * Created by <Adrien JEANCLOS> on <DATE-DU-JOUR>.
 */
public abstract class BaseActivity extends AppCompatActivity {

    //@Override
    //protected void onCreate(@Nullable Bundle savedInstanceState) {
    //    super.onCreate(savedInstanceState);
    //    this.setContentView(this.getFragmentLayout());
    //    ButterKnife.bind(this); //Configure Butterknife
    //}

    //public abstract int getFragmentLayout();


    // --------------------
    // ERROR HANDLER
    // --------------------

    protected OnFailureListener onFailureListener(){
        return new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(), getString(R.string.error_unknown_error), Toast.LENGTH_LONG).show();
            }
        };
    }

    // --------------------
    // UTILS
    // --------------------

    @Nullable
    protected FirebaseUser getCurrentUser(){ return FirebaseAuth.getInstance().getCurrentUser(); }

    protected Boolean isCurrentUserLogged(){ return (this.getCurrentUser() != null); }
}
