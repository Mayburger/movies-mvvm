package com.nacoda.moviesmvvm.mvvm.main;

import com.nacoda.moviesmvvm.data.model.Movie;

import org.jetbrains.annotations.NotNull;

/**
 * Created by Mayburger on 1/10/18.
 */

public interface MainItemUserActionListener {
    void onMovieClicked(@NotNull Movie movie);
}
