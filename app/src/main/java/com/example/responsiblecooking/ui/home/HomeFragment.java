package com.example.responsiblecooking.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.responsiblecooking.MainActivity;
import com.example.responsiblecooking.RecyclerViewAdapter;
import com.example.responsiblecooking.R;
import com.example.responsiblecooking.data.models.Recipe;
import com.google.firebase.database.DatabaseReference;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

public class HomeFragment extends Fragment {

    public HomeFragment() { }

    private HomeViewModel homeViewModel;

    //private static final String TAG = MainActivity.class.getSimpleName();

    private LinearLayoutManager linearLayoutManager;
    private RecyclerViewAdapter MyAdapter;
    private EditText addRecipeBox;
    private DatabaseReference databaseReference;
    private List<Recipe> allRecipes;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View result = inflater.inflate(R.layout.home_fragment, container, false);

        RecyclerView recyclerView = (RecyclerView) result.findViewById(R.id.recyclerViewHome);
        recyclerView.setHasFixedSize(true);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(new String[]{"Example One", "Example Two", "Example Three", "Example Four", "Example Five", "Example Six"});
        recyclerView.setAdapter(adapter);

        linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);

        return result;
    }
}
