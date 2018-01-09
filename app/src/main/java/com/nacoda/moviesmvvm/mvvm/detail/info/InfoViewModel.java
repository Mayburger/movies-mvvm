package com.nacoda.moviesmvvm.mvvm.detail.info;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.nacoda.moviesmvvm.data.model.Detail;
import com.nacoda.moviesmvvm.data.model.Movie;
import com.nacoda.moviesmvvm.data.source.MoviesDataSource;
import com.nacoda.moviesmvvm.data.source.MoviesRepository;

import java.util.List;

/**
 * Created by Mayburger on 1/9/18.
 */

public class InfoViewModel extends AndroidViewModel {

    private MoviesRepository moviesRepository;
    private Application application;

    ObservableField<String> backdrop_path;
    ObservableField<String> budget;
    ObservableField<String> overview;
    ObservableField<String> revenue;
    ObservableField<String> runtime;
    ObservableField<String> vote_average;
    ObservableField<String> vote_count;

    public InfoViewModel(@NonNull Application application, MoviesRepository moviesRepository) {
        super(application);
        this.moviesRepository = moviesRepository;
        this.application = application;
    }

    public void start(Movie movie) {
        moviesRepository.getDetail(new MoviesDataSource.GetDetailCallback() {
            @Override
            public void onDetailLoaded(Detail detail) {

            }

            @Override
            public void onDataNotAvailable() {

            }

            @Override
            public void onError(String errorMessage) {

            }
        }, String.valueOf(movie.getId()));
    }


}
