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
import com.example.movies_marc_mnicolas_oliva.models.Movie;
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
            // TODO: Write the code to update recycler view's row layout
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
                    Snackbar mySnack = Snackbar.make(v, "Ticket purchased.",
                            Snackbar.LENGTH_SHORT);
                    mySnack.show();
                }
            });
        }
    }
}


//            itemBinding.tvCharacterName.setText(currentItem.getName());
//            itemBinding.tvOrigin
//                    .setText("Originally From: " + currentItem.getOrigin().getName());
//
//            itemBinding.tvLastKnownLocation
//                    .setText("Last Known Location: " + currentItem.getLastKNownLocation().getName());

            // load the image
            // TODO: Glide.with(context).load(currentItem.).into(itemBinding.ivCharacterPhoto);

//            // update the text of the status
//            itemBinding.tvStatus.setText(currentItem.getStatus());
//
//            String currentStatus = currentItem.getStatus();
//            if (currentStatus.contentEquals("Alive")) {
//                // set the background color: green
//                itemBinding.tvStatus.setBackgroundColor(Color.parseColor("#27ae60"));
//            }
//            else if (currentStatus.contentEquals("Dead")) {
//                // set the background color: red
//                itemBinding.tvStatus.setBackgroundColor(Color.parseColor("#c0392b"));
//            }
//            else {
//                // set the background color: grey
//                itemBinding.tvStatus.setBackgroundColor(Color.parseColor("#34495e"));
//            }


//            // click detection
//            itemBinding.getRoot().setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    clickListener.OnItemClickListener(currentItem);
//                }
//            });
//        }
//    }
//}
