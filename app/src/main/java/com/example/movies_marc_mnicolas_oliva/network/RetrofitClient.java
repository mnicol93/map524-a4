package com.example.movies_marc_mnicolas_oliva.network;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

// A singleton that holds a concrete implementation of the API interface.
public class RetrofitClient {

    private API api;

    // constructor
    private RetrofitClient() {

        // create a client with logging
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();

        // setup the parser
        Gson gson = new GsonBuilder().create();

        // create the retrofit instance
        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        // use the retrofit instance to create a concrete implementation of the API interface
        api = retrofit.create(API.class);

    }

    // getter for the API
    public API getApi() {
        return api;
    }

    // singleton
    private static RetrofitClient instance = null;
    public static synchronized RetrofitClient getInstance(){
        if ( instance == null){
            instance = new RetrofitClient();
        }
        return instance;
    }
}
