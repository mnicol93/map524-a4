package com.example.movies_marc_mnicolas_oliva.db;

import static androidx.room.OnConflictStrategy.IGNORE;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.movies_marc_mnicolas_oliva.models.Movie;
import com.example.movies_marc_mnicolas_oliva.models.MovieEntity;

import java.util.List;

// data access object
// - specify the operations you want to perform (insert, delete, update, retrieve)
@Dao
public interface MovieDAO {
    @Insert(onConflict = IGNORE)
    public void insertMovie(MovieEntity movie);

    @Query("SELECT * FROM movies_table")
    public List<MovieEntity> getAllMovies();

    @Query("SELECT * FROM movies_table WHERE id = :movieId")
    public MovieEntity getMovieById(int movieId);
}
