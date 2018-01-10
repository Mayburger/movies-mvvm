package com.nacoda.moviesmvvm.mvvm.detail;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.nacoda.moviesmvvm.data.source.MoviesRepository;

/**
 * Created by Mayburger on 1/9/18.
 */

public class DetailViewModel extends AndroidViewModel {

    private MoviesRepository moviesRepository;

    public DetailViewModel(@NonNull Application application, MoviesRepository moviesRepository) {
        super(application);
        this.moviesRepository = moviesRepository;
    }
}
