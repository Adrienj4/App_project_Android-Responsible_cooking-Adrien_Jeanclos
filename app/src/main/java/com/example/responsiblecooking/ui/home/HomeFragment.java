package com.example.responsiblecooking.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.responsiblecooking.AddRecipeActivity;
import com.example.responsiblecooking.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.BindView;

public class HomeFragment extends Fragment {

    public HomeFragment() { }

    private HomeViewModel homeViewModel;

    // FOR DESIGN
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.home_fragment_swipe_container)
    SwipeRefreshLayout swipeRefreshLayout;
    //@BindView(R.id.floatingActionButtonAdd)
    //FloatingActionButton fabButton;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View result = inflater.inflate(R.layout.home_fragment, container, false);

        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);

        recyclerView.setHasFixedSize(true);

        // Set the animator
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        return result;
    }
    /*
    private void initUI(View view) {
        fabButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AddRecipeActivity.class);
                startActivity(intent);
            }
        });
    }
     */
}
