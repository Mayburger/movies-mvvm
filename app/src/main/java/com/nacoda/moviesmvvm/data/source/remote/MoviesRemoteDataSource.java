package com.nacoda.moviesmvvm.data.source.remote;

import com.nacoda.moviesmvvm.base.BaseApiModel;
import com.nacoda.moviesmvvm.data.model.Movie;
import com.nacoda.moviesmvvm.data.source.MoviesDataSource;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

import static com.nacoda.moviesmvvm.util.helper.Network.API_KEY;
import static com.nacoda.moviesmvvm.util.helper.Network.LANGUAGE_ENGLISH;

/**
 * Created by Mayburger on 1/9/18.
 */

public class MoviesRemoteDataSource implements MoviesDataSource {

    private MoviesService mApiService = MoviesService.Factory.create();

    @Override
    public void getPopular(@NotNull GetMoviesCallback callback) {
        mApiService.getPopular(
                API_KEY,
                LANGUAGE_ENGLISH,
                "1")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(results -> {
                    if (results != null) {
                        callback.onMoviesLoaded(results.getResults());
                    } else {
                        callback.onDataNotAvailable();
                    }
                });
    }

    @Override
    public void getNowPlaying(@NotNull GetMoviesCallback callback) {
        mApiService.getNowPlaying(
                API_KEY,
                LANGUAGE_ENGLISH,
                "1")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(results -> {
                    if (results != null) {
                        callback.onMoviesLoaded(results.getResults());
                    } else {
                        callback.onDataNotAvailable();
                    }
                });
    }

    @Override
    public void getTopRated(@NotNull GetMoviesCallback callback) {
        mApiService.getTopRated(
                API_KEY,
                LANGUAGE_ENGLISH,
                "1")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(results -> {
                    if (results != null) {
                        callback.onMoviesLoaded(results.getResults());
                    } else {
                        callback.onDataNotAvailable();
                    }
                });
    }

    @Override
    public void getSearch(@NotNull GetMoviesCallback callback, @NotNull String query) {
        mApiService.getSearch(
                API_KEY,
                LANGUAGE_ENGLISH,
                query)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(results -> {
                    if (results != null) {
                        callback.onMoviesLoaded(results.getResults());
                    } else {
                        callback.onDataNotAvailable();
                    }
                });
    }

    @Override
    public void getDetail(@NotNull GetDetailCallback callback, @NotNull String movieId) {
        mApiService.getDetail(
                API_KEY,
                movieId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(results -> {
                    if (results != null) {
                        callback.onDetailLoaded(results);
                    } else {
                        callback.onDataNotAvailable();
                    }
                });
    }

    @Override
    public void getCasts(@NotNull GetCastsCallback callback, @NotNull String movieId) {
        mApiService.getCasts
                (
                        API_KEY,
                        movieId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(results -> {
                    if (results != null) {
                        callback.onCastsLoaded(results);
                    } else {
                        callback.onDataNotAvailable();
                    }
                });
    }
}
