package com.example.irishka.movieapp.ui;

import com.arellomobile.mvp.MvpPresenter;
import com.arellomobile.mvp.MvpView;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class BasePresenter<T extends MvpView> extends MvpPresenter<T> {

    private CompositeDisposable disposables;

    public void addDisposables(Disposable disposable) {
        if(disposables == null) {
            disposables = new CompositeDisposable();
        }

        disposables.add(disposable);
    }

    private void dispose() {
        if(disposables != null) disposables.clear();
    }

    // TODO: этот onDestroy и onDestroy у view совершенно разные
    // скорее будет правильнее на detachView это делать
    @Override
    public void onDestroy() {
        dispose();
    }
}
