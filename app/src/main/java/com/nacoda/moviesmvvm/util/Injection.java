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
        MoviesRepository.Companion moviesRepository = MoviesRepository.Companion;
        MoviesDataSource moviesDataSource = new MoviesRemoteDataSource();
        return moviesRepository.getInstance(moviesDataSource, new MoviesLocalDataSource());
    }

    static {
        Injection var0 = new Injection();
        INSTANCE = var0;
    }
}
