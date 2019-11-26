package com.example.responsiblecooking.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.responsiblecooking.R;
import com.example.responsiblecooking.data.models.Recipe;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by <Adrien JEANCLOS> on <DATE-DU-JOUR>.
 */
public class RecipeAdapter /*extends RecyclerView.Adapter<RecipeAdapter.ViewHolder>*/ {
    /*
    private final AdapterView.OnItemClickListener listener;
    private List<Recipe> recipes;

    public RecipeAdapter(List<Recipe> recipes, AdapterView.OnItemClickListener listener){
        this.listener = listener;
        this.recipes = recipes;
    }

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.recipe_list_item, parent, false);
        return new ViewHolder(view);
    }


    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        viewHolder.bind(recipes.get(position), listener);
        viewHolder.title.setText(recipes.get(position).getTitle());
        viewHolder.readyInTime.setText(recipes.get(position).getReadyInMinutes().toString());
        viewHolder.servings.setText(recipes.get(position).getServings().toString());
        viewHolder.icon.setImageBitmap(recipes.get(position).getBitmap());
    }

    public int getItemCount() {
        return recipes.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView title;
        TextView readyInTime;
        TextView servings;
        ImageView icon;

        ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tv_title);
            readyInTime = itemView.findViewById(R.id.readyInTime);
            servings = itemView.findViewById(R.id.servings);
            icon = itemView.findViewById(R.id.iv_icon);
        }

        void bind(final Recipe recipe, final OnItemClickListener listener){
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(recipe);
                }
            });
        }

        @Override
        public void onClick(View view) {

        }
    }
    */
}
