package com.example.responsiblecooking.ui.recipes;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.responsiblecooking.R;
import com.example.responsiblecooking.base.BaseFragment;

public class RecipesFragment extends BaseFragment {

    public RecipesFragment() { }

    private RecipesViewModel mViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View result = inflater.inflate(R.layout.recipes_fragment, container, false);

        return result;
    }
}
