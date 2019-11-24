package com.example.responsiblecooking.ui.home;

import android.view.View;

import com.example.responsiblecooking.R;
import com.example.responsiblecooking.base.BaseFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.Nullable;

public class HomeFragment extends BaseFragment {

    public HomeFragment() { }

    private HomeViewModel homeViewModel;

    @Override
    public int getFragmentLayout() { return R.layout.home_fragment; }

    /*
    //FOR DATA
    private ProjectViewModel projectViewModel;
    public static final String REQUEST_ANDROID = "android material design";
    public static final String REQUEST_LOGO = "logo";
    public static final String REQUEST_LANDSCAPE = "landscape";

    // FOR DESIGN
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.home_fragment_swipe_container)
    SwipeRefreshLayout swipeRefreshLayout;
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

    FloatingActionButton fab = getActivity().findViewById(R.id.floatingActionButtonAdd);
    fab.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        }
    });
}
