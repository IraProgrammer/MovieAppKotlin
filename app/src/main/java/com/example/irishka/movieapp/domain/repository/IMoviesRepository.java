package com.example.irishka.movieapp.domain.repository;

import com.example.irishka.movieapp.data.models.DescriptionModel;
import com.example.irishka.movieapp.domain.entity.Description;
import com.example.irishka.movieapp.domain.entity.Movie;

import java.util.List;

import io.reactivex.Single;

public interface IMoviesRepository {
    Single<List<Movie>> downloadMovies();

    Single<Description> downloadDescription(long movieId);

    Single<List<Movie>> downloadRelatedMovies(long movieId);
}
