package com.example.movies_marc_mnicolas_oliva.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.movies_marc_mnicolas_oliva.databinding.CustomRowLayoutBinding;
import com.example.movies_marc_mnicolas_oliva.db.MyDatabase;
import com.example.movies_marc_mnicolas_oliva.models.Movie;
import com.example.movies_marc_mnicolas_oliva.models.MovieEntity;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {
    private final Context context;
    private final ArrayList<Movie> itemArrayList;
    CustomRowLayoutBinding binding;

    public ItemAdapter(Context context, ArrayList<Movie> items){
        this.itemArrayList = items;
        this.context = context;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemViewHolder(CustomRowLayoutBinding.inflate(LayoutInflater.from(context), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Movie currentItem = itemArrayList.get(position);
        holder.bind(context, currentItem);
    }

    @Override
    public int getItemCount() {
        Log.d("ItemAdapter", "getItemCount: Number of items " +this.itemArrayList.size() );
        return this.itemArrayList.size();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder{
        CustomRowLayoutBinding itemBinding;

        public ItemViewHolder(CustomRowLayoutBinding binding){
            super(binding.getRoot());
            this.itemBinding = binding;
        }

        public void bind(Context context, Movie currentItem){
            MyDatabase db;

            db = MyDatabase.getDatabase(context.getApplicationContext());

            int rating = 0;
            itemBinding.tvTitle.setText(currentItem.getTitle());
            rating = (int)Math.round(10 * currentItem.getVote_average());
            itemBinding.tvRating.setText((Integer.toString(rating)) + "% ");
            itemBinding.tvDescription.setText(currentItem.getOverview());

            Glide.with(context).load(currentItem.getImgUrl()).into(itemBinding.ivItemPhoto);

            itemBinding.btnBuyTicket.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Add one to Database
                    String title = currentItem.getTitle();
                    int id = currentItem.getId();

                    MovieEntity currentMovie = db.movieDAO().getMovieById(id);

                    if(currentMovie == null) {
                        //MovieEntity movie = new MovieEntity(title, 1);
                        db.movieDAO().insertMovie(new MovieEntity(title, 1, id));

                        Snackbar mySnack = Snackbar.make(v, "Ticket purchased.",
                                Snackbar.LENGTH_SHORT);
                        mySnack.show();
                    }
                    else{
                        // Update adding one
                        Log.d("ABC", "BIEN");
                    }

                }
            });
        }
    }
}
