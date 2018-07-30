package com.example.irishka.movieapp.ui.movies.view;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.example.irishka.movieapp.R;
import com.example.irishka.movieapp.domain.entity.Movie;
import com.example.irishka.movieapp.ui.movie.view.MovieActivity;
import com.example.irishka.movieapp.ui.movies.presenter.MoviesListPresenter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.inject.Provider;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.Provides;
import dagger.android.AndroidInjection;

public class MoviesListActivity extends MvpAppCompatActivity implements MoviesListView, MoviesListAdapter.OnItemClickListener {

    public static final String MOVIE_ID = "id_of_movie";

    @BindView(R.id.movies_recycler_view)
    RecyclerView moviesRecyclerView;

    @Inject
    Provider<MoviesListPresenter> moviesPresenterProvider;

    @InjectPresenter
    MoviesListPresenter moviesPresenter;

    @ProvidePresenter
    MoviesListPresenter providePresenter() {
        return moviesPresenterProvider.get();
    }

    @Inject
    MoviesListAdapter moviesAdapter;

    private boolean isLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);
        ButterKnife.bind(this);

        moviesRecyclerView.setLayoutManager(getLayoutManager());

        moviesRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                int visibleItemCount = recyclerView.getLayoutManager().getChildCount();
                int totalItemCount = recyclerView.getLayoutManager().getItemCount();
                int lastVisibleItemPosition = getLastVisibleItemPosition();

                if (isLoading) return;
                if ((totalItemCount - visibleItemCount) <= (lastVisibleItemPosition + 20)
                        && lastVisibleItemPosition >= 0) {
                    isLoading = true;
                    moviesPresenter.downloadMovies();
                }
            }
        });

        moviesRecyclerView.setAdapter(moviesAdapter);

    }

    private int getColumns() {
        Point point = new Point();
        getWindowManager().getDefaultDisplay().getSize(point);
        int number = point.x;
        float scalefactor = getResources().getDisplayMetrics().density * 150;
        return (int) ((float) number / (float) scalefactor);
    }

    // TODO: можно даггером предоставлять
    private StaggeredGridLayoutManager getLayoutManager() {
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(getColumns(), StaggeredGridLayoutManager.VERTICAL);
        staggeredGridLayoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);
        return staggeredGridLayoutManager;
    }

    @Override
    public void showMovies(List<Movie> movies) {
        moviesAdapter.setMoviesList(movies);
    }

    @Override
    public void finishLoading() {
        isLoading = false;
    }

    private int getLastVisibleItemPosition() {
        //TODO: раз у тебя в 2-х местах дергается StaggeredGridLayoutManager, то имеет смысл хранить его как поле в активити
        StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) moviesRecyclerView.getLayoutManager();
        // TODO: студия говорит, что может быть NLP
        int[] into = staggeredGridLayoutManager.findLastVisibleItemPositions(null);
        List<Integer> intoList = new ArrayList<>();
        for (int i : into) {
            intoList.add(i);
        }
        return Collections.max(intoList);
    }

    @Override
    public void onItemClick(Movie movie) {
        Intent intent = new Intent(this, MovieActivity.class);
        intent.putExtra(MOVIE_ID, movie.getId());
        startActivity(intent);
    }
}
