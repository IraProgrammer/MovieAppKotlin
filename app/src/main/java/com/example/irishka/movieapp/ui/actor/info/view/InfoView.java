package com.example.irishka.movieapp.ui.actor.info.view;

import com.arellomobile.mvp.MvpView;
import com.example.irishka.movieapp.data.models.ActorInfoModel;
import com.example.irishka.movieapp.data.models.ActorPhotosModel;
import com.example.irishka.movieapp.domain.entity.Cast;

public interface InfoView extends MvpView {

    void showProgress();

    void showError();

    void hideError();

    void hideProgress();

    void showInfo(Cast cast);

}
