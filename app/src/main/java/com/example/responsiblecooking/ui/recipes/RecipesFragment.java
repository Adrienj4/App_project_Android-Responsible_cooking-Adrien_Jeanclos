package com.example.responsiblecooking.ui.recipes;

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

    @Override
    public int getFragmentLayout() { return R.layout.recipes_fragment; }
    /*
    public static RecipesFragment newInstance() {
        return new RecipesFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.recipes_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(RecipesViewModel.class);
        // TODO: Use the ViewModel
    }
    */

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.recipes_fragment, container, false);
    }
}
