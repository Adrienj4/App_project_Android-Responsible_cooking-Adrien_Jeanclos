package com.example.responsiblecooking.ui.profile;

import com.example.responsiblecooking.R;
import com.example.responsiblecooking.base.BaseFragment;
import com.google.firebase.auth.FirebaseUser;

public class ProfileFragment extends BaseFragment {

    public ProfileFragment() { }

    private ProfileViewModel profileViewModel;

    @Override
    public int getFragmentLayout() { return R.layout.profile_fragment; }
}
