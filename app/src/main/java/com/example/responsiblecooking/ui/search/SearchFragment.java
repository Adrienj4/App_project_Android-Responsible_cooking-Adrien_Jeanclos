package com.example.responsiblecooking.ui.search;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.responsiblecooking.R;
import com.example.responsiblecooking.base.BaseFragment;

public class SearchFragment extends BaseFragment {

    public SearchFragment() { }

    private SearchViewModel mViewModel;

    @Override
    public int getFragmentLayout() { return R.layout.search_fragment; }
}
