package com.example.irishka.movieapp.data.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.irishka.movieapp.data.database.entity.MovieDb;

import java.util.List;

import io.reactivex.Single;

@Dao
public interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<MovieDb> concreteMovies);

    @Query("SELECT * FROM MovieDb")
    Single<List<MovieDb>> getAllMovies();

}