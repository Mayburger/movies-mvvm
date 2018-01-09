package com.nacoda.moviesmvvm.mvvm.detail;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.support.annotation.NonNull;

import com.nacoda.moviesmvvm.data.model.Movie;
import com.nacoda.moviesmvvm.data.source.MoviesDataSource;
import com.nacoda.moviesmvvm.data.source.MoviesRepository;

import java.util.List;

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
