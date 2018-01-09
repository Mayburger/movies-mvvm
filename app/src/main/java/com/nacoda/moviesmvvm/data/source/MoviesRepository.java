package com.nacoda.moviesmvvm.data.source;

import com.nacoda.moviesmvvm.data.model.Casts;
import com.nacoda.moviesmvvm.data.model.Detail;
import com.nacoda.moviesmvvm.data.model.Movie;

import java.util.List;

/**
 * Created by Mayburger on 1/9/18.
 */

public class MoviesRepository implements MoviesDataSource {

    private MoviesDataSource remoteDataSource;
    MoviesDataSource localDataSource;

    public MoviesRepository(MoviesDataSource remoteDataSource, MoviesDataSource localDataSource) {
        this.remoteDataSource = remoteDataSource;
        this.localDataSource = localDataSource;
    }


    @Override
    public void getPopular(GetMoviesCallback callback) {
        remoteDataSource.getPopular(new GetMoviesCallback() {
            @Override
            public void onMoviesLoaded(List<Movie> movies) {
                callback.onMoviesLoaded(movies);
            }

            @Override
            public void onDataNotAvailable() {
                callback.onDataNotAvailable();
            }

            @Override
            public void onError(String errorMessage) {
                callback.onError(errorMessage);
            }
        });
    }

    @Override
    public void getNowPlaying(GetMoviesCallback callback) {
        remoteDataSource.getNowPlaying(new GetMoviesCallback() {
            @Override
            public void onMoviesLoaded(List<Movie> movies) {
                callback.onMoviesLoaded(movies);
            }

            @Override
            public void onDataNotAvailable() {
                callback.onDataNotAvailable();
            }

            @Override
            public void onError(String errorMessage) {
                callback.onError(errorMessage);
            }
        });
    }

    @Override
    public void getTopRated(GetMoviesCallback callback) {
        remoteDataSource.getTopRated(new GetMoviesCallback() {
            @Override
            public void onMoviesLoaded(List<Movie> movies) {
                callback.onMoviesLoaded(movies);
            }

            @Override
            public void onDataNotAvailable() {
                callback.onDataNotAvailable();
            }

            @Override
            public void onError(String errorMessage) {
                callback.onError(errorMessage);
            }
        });
    }

    @Override
    public void getSearch(GetMoviesCallback callback, String query) {
        remoteDataSource.getSearch(new GetMoviesCallback() {
            @Override
            public void onMoviesLoaded(List<Movie> movies) {
                callback.onMoviesLoaded(movies);
            }

            @Override
            public void onDataNotAvailable() {
                callback.onDataNotAvailable();
            }

            @Override
            public void onError(String errorMessage) {
                callback.onError(errorMessage);
            }
        }, query);
    }

    @Override
    public void getDetail(GetDetailCallback callback, String movieId) {
        remoteDataSource.getDetail(new GetDetailCallback() {
            @Override
            public void onDetailLoaded(Detail detail) {
                callback.onDetailLoaded(detail);
            }

            @Override
            public void onDataNotAvailable() {
                callback.onDataNotAvailable();
            }

            @Override
            public void onError(String errorMessage) {
                callback.onError(errorMessage);
            }
        }, movieId);
    }

    @Override
    public void getCasts(GetCastsCallback callback, String movieId) {
        remoteDataSource.getCasts(new GetCastsCallback() {
            @Override
            public void onCastsLoaded(Casts casts) {
                callback.onCastsLoaded(casts);
            }

            @Override
            public void onDataNotAvailable() {
                callback.onDataNotAvailable();
            }

            @Override
            public void onError(String errorMessage) {
                callback.onError(errorMessage);
            }
        }, movieId);
    }
}
