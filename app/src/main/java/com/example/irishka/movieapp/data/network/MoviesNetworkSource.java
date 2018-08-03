package com.example.irishka.movieapp.data.network;

import com.example.irishka.movieapp.data.database.dao.CastDao;
import com.example.irishka.movieapp.data.database.dao.CastOfMovieDao;
import com.example.irishka.movieapp.data.database.dao.GenreDao;
import com.example.irishka.movieapp.data.database.dao.GenreOfMovieDao;
import com.example.irishka.movieapp.data.database.dao.MovieDao;
import com.example.irishka.movieapp.data.database.entity.MovieDb;
import com.example.irishka.movieapp.data.models.ActorInfoModel;
import com.example.irishka.movieapp.data.models.ActorPhotosModel;
import com.example.irishka.movieapp.data.models.BackdropModel;
import com.example.irishka.movieapp.data.models.CastModel;
import com.example.irishka.movieapp.data.models.CreditsModel;
import com.example.irishka.movieapp.data.models.DescriptionModel;
import com.example.irishka.movieapp.data.models.FilmsModel;
import com.example.irishka.movieapp.data.models.GalleryModel;
import com.example.irishka.movieapp.data.models.MovieModel;
import com.example.irishka.movieapp.data.models.MoviePageModel;
import com.example.irishka.movieapp.data.models.TrailerListModel;
import com.example.irishka.movieapp.data.models.TrailerModel;
import com.example.irishka.movieapp.domain.entity.Cast;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

public class MoviesNetworkSource {

    private MoviesApi moviesApi;

    @Inject
    public MoviesNetworkSource(MoviesApi moviesApi) {
        this.moviesApi = moviesApi;
    }

    public Single<List<MovieModel>> getMovies(int page){
        return moviesApi.getMovies(page)
                .map(MoviePageModel::getResults);
    }

    public Single<List<MovieModel>> getRelated(long movieId, int page){
        return moviesApi.getRelated(movieId, page)
                .map(MoviePageModel::getResults);
    }

    public Single<List<CastModel>> getCasts(long movieId){
        return moviesApi.getCreators(movieId)
                .map(CreditsModel::getCast);
    }

    public Single<List<BackdropModel>> getBackdrops(long movieId){
        return moviesApi.getGallery(movieId)
                .map(GalleryModel::getBackdrops);
    }

    public Single<DescriptionModel> getDescription(long movieId){
        return moviesApi.getDescription(movieId);
    }

    public Single<ActorPhotosModel> getActorPhotos(long id){
        return moviesApi.getActorPhotos(id);
    }

    public Single<ActorInfoModel> getActorInfo(long id){
        return moviesApi.getActorInfo(id);
    }

    public Single<List<MovieModel>> getActorFilms(long id){
        return moviesApi.getActorFilms(id)
                .map(FilmsModel::getMovies);
    }

    public Single<List<TrailerModel>> getTrailers(long movieId) {
        return  moviesApi.getTrailers(movieId)
                .map(TrailerListModel::getResults); }
}
