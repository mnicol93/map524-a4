package com.example.movies_marc_mnicolas_oliva.adapter;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.movies_marc_mnicolas_oliva.databinding.CustomRowLayoutBinding;
import com.example.movies_marc_mnicolas_oliva.databinding.RowQuantitiesBinding;
import com.example.movies_marc_mnicolas_oliva.db.MyDatabase;
import com.example.movies_marc_mnicolas_oliva.models.Movie;
import com.example.movies_marc_mnicolas_oliva.models.MovieEntity;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class QuantityAdapter extends RecyclerView.Adapter<QuantityAdapter.ItemViewHolder> {
    private final Context context;
    private final ArrayList<MovieEntity> itemArrayList;
    CustomRowLayoutBinding binding;

    public QuantityAdapter(Context context, ArrayList<MovieEntity> items){
        this.itemArrayList = items;
        this.context = context;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemViewHolder(RowQuantitiesBinding.inflate(LayoutInflater.from(context), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        MovieEntity currentItem = itemArrayList.get(position);
        holder.bind(context, currentItem);
    }

    @Override
    public int getItemCount() {
        Log.d("ItemAdapter", "getItemCount: Number of items " +this.itemArrayList.size() );
        return this.itemArrayList.size();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder{
        RowQuantitiesBinding itemBinding;

        public ItemViewHolder(RowQuantitiesBinding binding){
            super(binding.getRoot());
            this.itemBinding = binding;
        }

        public void bind(Context context, MovieEntity currentItem){
            MyDatabase db;

            db = MyDatabase.getDatabase(context.getApplicationContext());

            itemBinding.tvTitle.setText(currentItem.getTitle());
            itemBinding.tvQuantity.setText("Tickets purchased: " + currentItem.getQuantity());

            itemBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    db.movieDAO().deleteMovie(currentItem);
                    Snackbar mySnack = Snackbar.make(v, "Deleted!",
                            Snackbar.LENGTH_SHORT);
                    mySnack.show();
                }
            });
        }
    }
}
