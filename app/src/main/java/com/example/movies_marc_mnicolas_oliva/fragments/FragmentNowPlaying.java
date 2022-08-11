package com.example.movies_marc_mnicolas_oliva.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.movies_marc_mnicolas_oliva.R;
import com.example.movies_marc_mnicolas_oliva.adapter.ItemAdapter;
import com.example.movies_marc_mnicolas_oliva.databinding.FragmentNowPlayingBinding;
import com.example.movies_marc_mnicolas_oliva.db.MyDatabase;
import com.example.movies_marc_mnicolas_oliva.models.ItemResponse;
import com.example.movies_marc_mnicolas_oliva.models.Movie;
import com.example.movies_marc_mnicolas_oliva.network.API;
import com.example.movies_marc_mnicolas_oliva.network.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentNowPlaying #newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentNowPlaying extends Fragment {
    private ArrayList<Movie> movieItemsList = new ArrayList<>();

    private ItemAdapter adapter;

    private API api;

    private FragmentNowPlayingBinding binding;

    public FragmentNowPlaying() {
        super(R.layout.fragment_now_playing);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        // Click handlers and logic
        // Configure API Client
        this.api = RetrofitClient.getInstance().getApi();
        // configure the recyclerview
        adapter = new ItemAdapter(this.getActivity(), movieItemsList);
        binding.rvMovies.setAdapter(adapter);
        binding.rvMovies.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        // Get API data
        Call<ItemResponse> request = this.api.getAllItems();

        request.enqueue(new Callback<ItemResponse>() {
            @Override
            public void onResponse(Call<ItemResponse> call, Response<ItemResponse> response) {
                if(!response.isSuccessful()){
                    Log.d("ABC", "Error, couldn't GET: " + response.code());
                }
                ItemResponse obj = response.body();
                List<Movie> moviesAPI = obj.getResults();

                movieItemsList.clear();
                movieItemsList.addAll(moviesAPI);

                adapter.notifyDataSetChanged();
            }
            @Override
            public void onFailure(Call<ItemResponse> call, Throwable t) {
                Log.d("ABC", "Error, couldn't GET: " + t.getMessage());
            }
        });
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentNowPlayingBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }
    @Override
    public void onDestroyView(){
        super.onDestroyView();
        binding = null;
    }

}