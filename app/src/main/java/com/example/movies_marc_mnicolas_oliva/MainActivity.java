package com.example.movies_marc_mnicolas_oliva;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavHost;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;

import com.example.movies_marc_mnicolas_oliva.adapter.ItemAdapter;
import com.example.movies_marc_mnicolas_oliva.databinding.ActivityMainBinding;
import com.example.movies_marc_mnicolas_oliva.models.ItemResponse;
import com.example.movies_marc_mnicolas_oliva.models.Movie;
import com.example.movies_marc_mnicolas_oliva.network.API;
import com.example.movies_marc_mnicolas_oliva.network.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Get a reference to the FragmentContainerView
        // Use the FCV to retrieve a reference to the Navigation Controller
        NavHostFragment navHostFragment =
                (NavHostFragment) getSupportFragmentManager()
                                  .findFragmentById(R.id.nav_host_fragment);
        // Associate the bottom navigation view component with the navigation controller
        NavController navController = navHostFragment.getNavController();
        // Navigation Controller will automatically manage switching between
        // fragments when options are clicked
        NavigationUI.setupWithNavController(binding.bottomNavigationView, navController);

        // TODO: Move to FragmentNowPlaying
//        // Configure API Client
//        this.api = RetrofitClient.getInstance().getApi();
//        // configure the recyclerview
//        adapter = new ItemAdapter(this, movieItemsList);
//        binding.rvMovies.setAdapter(adapter);
//        binding.rvMovies.setLayoutManager(new LinearLayoutManager(this));
//        // Get API data
//        Call<ItemResponse> request = this.api.getAllItems();
        //
    }
}