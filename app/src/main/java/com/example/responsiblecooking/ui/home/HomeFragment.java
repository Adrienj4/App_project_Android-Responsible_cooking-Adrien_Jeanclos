package com.example.responsiblecooking.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.responsiblecooking.AddRecipeActivity;
import com.example.responsiblecooking.R;
import com.example.responsiblecooking.base.BaseFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
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
    @BindView(R.id.floatingActionButtonAdd)
    FloatingActionButton fabButton;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View result = inflater.inflate(R.layout.home_fragment, container, false);
        initUI(result);
        return result;
    }

    private void initUI(View view) {
        fabButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AddRecipeActivity.class);
                startActivity(intent);
            }
        });
    }

    /*
    //FOR DATA
    private ProjectViewModel projectViewModel;
    public static final String REQUEST_ANDROID = "android material design";
    public static final String REQUEST_LOGO = "logo";
    public static final String REQUEST_LANDSCAPE = "landscape";
     */

    /*
    private ProjectAdapter projectAdapter;

    @Override
    protected int getLayoutId() { return R.layout.home_fragment; }

    @Override
    protected void updateData() {
        this.configureViewModel();
        this.configureRecyclerView();
        this.getProjects();

    // -------------------
    // CONFIGURATION
    // -------------------

    private void configureViewModel(){
        ViewModelFactory mViewModelFactory = Injection.provideViewModelFactory();
        this.projectViewModel = ViewModelProviders.of(this, mViewModelFactory).get(ProjectViewModel.class);
        this.projectViewModel.init(REQUEST_ANDROID);
    }

    private void configureRecyclerView(){
        this.projectAdapter = new ProjectAdapter(new ArrayList<>(), Glide.with(this));
        this.recyclerView.setAdapter(this.projectAdapter);
        this.recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        ItemClickSupport.addTo(recyclerView, R.layout.home_item_fragment)
                .setOnItemClickListener((rv, position, v) -> this.navigateToDetail(this.projectAdapter.getProject(position), v));
        this.swipeRefreshLayout.setOnRefreshListener(() -> this.refreshProjects(REQUEST_ANDROID));
    }

     */
}
