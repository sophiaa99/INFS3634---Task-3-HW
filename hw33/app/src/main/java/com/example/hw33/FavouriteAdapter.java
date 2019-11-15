package com.example.hw33;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FavouriteAdapter extends RecyclerView.Adapter<FavouriteAdapter.FavouriteViewHolder> {

    public static ArrayList<Search> favToAdapt;
    public void setData(ArrayList<Search> favToAdapt)
    {this.favToAdapt = favToAdapt;}


    @NonNull
    @Override
    public FavouriteAdapter.FavouriteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.favourite_row_item, parent, false);
        FavouriteViewHolder favouriteViewHolder = new FavouriteViewHolder(view);
        return favouriteViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FavouriteAdapter.FavouriteViewHolder holder, int position) {

        holder.nameCat.setText(favToAdapt.get(position).getName());


    }

    @Override
    public int getItemCount() {
        return favToAdapt.size();

    }

    public static class FavouriteViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public TextView nameCat;

        public FavouriteViewHolder(View itemView) {
            super(itemView);
            view =itemView;
            nameCat = itemView.findViewById(R.id.fav_catName);



        }
    }
}
