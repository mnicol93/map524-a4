package com.example.movies_marc_mnicolas_oliva;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavHost;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.example.movies_marc_mnicolas_oliva.databinding.ActivityMainBinding;
import com.example.movies_marc_mnicolas_oliva.models.Movie;
import com.example.movies_marc_mnicolas_oliva.network.API;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private ArrayList<Movie> movieItemsList = new ArrayList<>();

    private API api;

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
    }
}