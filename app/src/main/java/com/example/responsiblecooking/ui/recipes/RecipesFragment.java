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
}
