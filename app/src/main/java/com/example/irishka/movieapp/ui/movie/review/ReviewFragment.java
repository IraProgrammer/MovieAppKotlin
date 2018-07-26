package com.example.irishka.movieapp.ui.movie.review;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.irishka.movieapp.R;
import com.example.irishka.movieapp.ui.movie.view.MovieFragment;

import dagger.android.support.AndroidSupportInjection;

public class ReviewFragment extends MovieFragment {

    public static ReviewFragment newInstance(){
        return new ReviewFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_trailers, container, false);
    }

    @Override
    public String getTitle() {
        return "Review";
    }

}