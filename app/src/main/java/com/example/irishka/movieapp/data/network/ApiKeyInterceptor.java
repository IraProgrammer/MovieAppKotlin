package com.example.irishka.movieapp.data.network;

import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.example.irishka.movieapp.BuildConfig;

import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Singleton;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

@Singleton
public class ApiKeyInterceptor implements Interceptor {

    @Inject
    public ApiKeyInterceptor(){}

    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        Request request = chain.request();
        HttpUrl url = request.url().newBuilder().addQueryParameter("api_key", BuildConfig.MOVIE_API_KEY).build();
        request = request.newBuilder().url(url).build();
        return chain.proceed(request);
    }
}
