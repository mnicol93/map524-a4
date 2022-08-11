package com.example.movies_marc_mnicolas_oliva.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.movies_marc_mnicolas_oliva.models.MovieEntity;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {MovieEntity.class}, version=1, exportSchema = false)
 public abstract class MyDatabase extends RoomDatabase {
     // TODO: List your DAOs here
     public abstract  MovieDAO movieDAO();

     private static volatile MyDatabase INSTANCE;
     private static final int NUMBER_OF_THREADS = 4;
     static final ExecutorService databaseWriteExecutor =
             Executors.newFixedThreadPool(NUMBER_OF_THREADS);

     public static MyDatabase getDatabase(final Context context) {
         if (INSTANCE == null) {
             synchronized (MyDatabase.class) {
                 if (INSTANCE == null) {
                     INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                     MyDatabase.class, "mydb")
                             .allowMainThreadQueries()
                             .fallbackToDestructiveMigration()
                             .build();
                 }
             }
         }
         return INSTANCE;
     }

 }