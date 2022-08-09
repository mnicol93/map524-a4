package com.example.movies_marc_mnicolas_oliva.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.movies_marc_mnicolas_oliva.R;
import com.example.movies_marc_mnicolas_oliva.databinding.FragmentNowPlayingBinding;
import com.example.movies_marc_mnicolas_oliva.databinding.FragmentTicketsBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentTickets #newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentTickets extends Fragment {
    private FragmentTicketsBinding binding;

    public FragmentTickets() {
        super(R.layout.fragment_now_playing);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        // click handlers and logic
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