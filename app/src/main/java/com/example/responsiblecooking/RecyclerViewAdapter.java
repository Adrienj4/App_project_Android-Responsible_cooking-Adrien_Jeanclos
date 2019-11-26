package com.example.responsiblecooking;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.card.MaterialCardView;

import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by <Adrien JEANCLOS> on <DATE-DU-JOUR>.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private String[] mDataset;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public MaterialCardView materialCardView;
        public TextView textView;

        public MyViewHolder (View view) {
            super(view);

            materialCardView = (MaterialCardView) view.findViewById(R.id.cardViewHome);
            textView = (TextView) view.findViewById(R.id.textViewRecipeTitle);
        }
    }

    public RecyclerViewAdapter(String[] myDataset) {
        mDataset = myDataset;
    }

    @Override
    public RecyclerViewAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_item_fragment, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position){
        holder.textView.setText(mDataset[position]);
    }

    @Override
    public int getItemCount() { return mDataset.length; }
}
