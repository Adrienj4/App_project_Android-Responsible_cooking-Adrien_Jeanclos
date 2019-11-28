package com.example.responsiblecooking.ui.profile;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.responsiblecooking.R;
import com.example.responsiblecooking.adapters.UserHelper;
import com.example.responsiblecooking.base.BaseActivity;
import com.example.responsiblecooking.base.BaseFragment;
import com.example.responsiblecooking.data.models.User;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import butterknife.BindView;

public class ProfileFragment extends Fragment {

    public ProfileFragment() { }

    private ProfileViewModel profileViewModel;

    @BindView(R.id.textViewUserName)
    TextView textViewUserName;
    @BindView(R.id.textViewUserEmail)
    TextView textViewUserEmail;

    FirebaseUser user;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View result = inflater.inflate(R.layout.profile_fragment, container, false);

        user = FirebaseAuth.getInstance().getCurrentUser();

        TextView textViewUserName = (TextView)result.findViewById(R.id.textViewUserName);
        TextView textViewUserEmail = (TextView)result.findViewById(R.id.textViewUserEmail);
        textViewUserName.setText(user.getDisplayName());
        textViewUserEmail.setText(user.getEmail());

        return result;
    }
}
