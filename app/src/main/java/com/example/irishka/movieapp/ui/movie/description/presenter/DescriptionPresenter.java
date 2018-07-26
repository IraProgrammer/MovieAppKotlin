package com.example.irishka.movieapp.ui.movie.description.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.irishka.movieapp.domain.repository.IMoviesRepository;
import com.example.irishka.movieapp.ui.BasePresenter;
import com.example.irishka.movieapp.ui.movie.description.view.DescriptionView;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

@InjectViewState
public class DescriptionPresenter extends BasePresenter<DescriptionView> {

    private IMoviesRepository moviesRepository;

    private Disposable disposable;

    private final long movieId;

    @Inject
    public DescriptionPresenter(IMoviesRepository repository, long movieId) {
        this.moviesRepository = repository;
        this.movieId = movieId;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        downloadDescription(movieId);
        downloadRelatedMovies(movieId);
        downloadGallery(movieId);
    }

    public void downloadDescription(long movieId) {

        addDisposables(moviesRepository.downloadDescription(movieId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(movies -> getViewState().showDescription(movies), Throwable::printStackTrace));
    }

    public void downloadRelatedMovies(long movieId) {

        addDisposables(disposable = moviesRepository.downloadRelatedMovies(movieId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(movies -> getViewState().showRelatedMovies(movies), Throwable::printStackTrace));
    }

    public void downloadGallery(long movieId) {

        addDisposables(disposable = moviesRepository.downloadGallery(movieId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(images -> getViewState().showGallery(images), Throwable::printStackTrace));
    }
}
