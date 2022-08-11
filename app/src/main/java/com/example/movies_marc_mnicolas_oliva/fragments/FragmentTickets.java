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
import com.example.movies_marc_mnicolas_oliva.adapter.QuantityAdapter;
import com.example.movies_marc_mnicolas_oliva.databinding.FragmentNowPlayingBinding;
import com.example.movies_marc_mnicolas_oliva.databinding.FragmentTicketsBinding;
import com.example.movies_marc_mnicolas_oliva.db.MyDatabase;
import com.example.movies_marc_mnicolas_oliva.models.MovieEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentTickets #newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentTickets extends Fragment {
    private FragmentTicketsBinding binding;

    private ArrayList<MovieEntity> moviesList = new ArrayList<>();

    private QuantityAdapter adapter;

    public FragmentTickets() {
        super(R.layout.fragment_now_playing);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        // click handlers and logic
        adapter = new QuantityAdapter(this.getActivity(), moviesList);
        binding.rvTickets.setAdapter(adapter);
        binding.rvTickets.setLayoutManager(new LinearLayoutManager(this.getActivity()));

        MyDatabase db;

        db = MyDatabase.getDatabase(this.getActivity());

        List<MovieEntity> movieList = db.movieDAO().getAllMovies();

        moviesList.clear();
        moviesList.addAll(movieList);

        adapter.notifyDataSetChanged();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTicketsBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }
    @Override
    public void onDestroyView(){
        super.onDestroyView();
        binding = null;
    }
}