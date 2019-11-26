package com.example.responsiblecooking;

import android.view.View;
import android.widget.TextView;

import com.example.responsiblecooking.data.models.Recipe;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by <Adrien JEANCLOS> on <DATE-DU-JOUR>.
 */
public class RecyclerViewHolders extends RecyclerView.ViewHolder {

    private static final String TAG = RecyclerViewHolders.class.getSimpleName();
    public TextView recipeTitle;
    private List<Recipe> recipesObject;

    public RecyclerViewHolders(final View itemView, final List<Recipe> recipesObject) {
        super(itemView);
        this.recipesObject = recipesObject;
        recipeTitle = (TextView)itemView.findViewById(R.id.textViewRecipeTitle);
    }
}
