package com.nacoda.moviesmvvm.util;

import android.content.Context;

import com.nacoda.moviesmvvm.data.source.MoviesDataSource;
import com.nacoda.moviesmvvm.data.source.MoviesRepository;
import com.nacoda.moviesmvvm.data.source.local.MoviesLocalDataSource;
import com.nacoda.moviesmvvm.data.source.remote.MoviesRemoteDataSource;

/**
 * Created by Mayburger on 1/9/18.
 */

class Injection {

    static volatile Injection INSTANCE;

    final MoviesRepository provideMoviesRepository(Context mContext) {
        MoviesDataSource moviesDataSource = new MoviesRemoteDataSource();
        return new MoviesRepository(moviesDataSource, new MoviesLocalDataSource());
    }

    static {
        Injection var0 = new Injection();
        INSTANCE = var0;
    }
}
