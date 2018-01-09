package com.nacoda.moviesmvvm.data.source.local;
import com.nacoda.moviesmvvm.data.source.MoviesDataSource;
import org.jetbrains.annotations.NotNull;

/**
 * Created by Mayburger on 1/9/18.
 */

public class MoviesLocalDataSource implements MoviesDataSource {

    @Override
    public void getPopular(@NotNull GetMoviesCallback callback) {

    }

    @Override
    public void getNowPlaying(@NotNull GetMoviesCallback callback) {

    }

    @Override
    public void getTopRated(@NotNull GetMoviesCallback callback) {

    }

    @Override
    public void getSearch(@NotNull GetMoviesCallback callback, @NotNull String query) {

    }

    @Override
    public void getDetail(@NotNull GetDetailCallback callback, @NotNull String movieId) {

    }

    @Override
    public void getCasts(@NotNull GetCastsCallback callback, @NotNull String movieId) {

    }
}
