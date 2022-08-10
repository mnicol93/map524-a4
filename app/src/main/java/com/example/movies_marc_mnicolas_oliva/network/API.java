package com.example.movies_marc_mnicolas_oliva.network;
//TODO: import
//import com.example.a3_marcn_mnicolas_oliva.models.ItemResponse;
//import com.example.a3_marcn_mnicolas_oliva.models.Zelda;

import com.example.movies_marc_mnicolas_oliva.models.ItemResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface API {
    // Base URL
    public final String BASE_URL = "https://api.themoviedb.org/3/movie/";
    // Connection endpoints
    @GET("now_playing?api_key=e4bbf7fb86a88e4c7e05699aaec48772&language=en-US&page=1&region=CA")
    public Call<ItemResponse> getAllItems();

}
