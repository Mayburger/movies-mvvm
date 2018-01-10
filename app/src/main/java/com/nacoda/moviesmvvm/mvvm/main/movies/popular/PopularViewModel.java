package com.nacoda.moviesmvvm.mvvm.main.movies.popular;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.nacoda.moviesmvvm.data.model.Movie;
import com.nacoda.moviesmvvm.data.source.MoviesDataSource;
import com.nacoda.moviesmvvm.data.source.MoviesRepository;

import java.util.List;

/**
 * Created by Mayburger on 1/9/18.
 */

public class PopularViewModel extends AndroidViewModel {

    private MoviesRepository moviesRepository;
    private Application application;

    public PopularViewModel(@NonNull Application application, MoviesRepository moviesRepository) {
        super(application);
        this.moviesRepository = moviesRepository;
        this.application = application;
    }

    public void start(RecyclerView recyclerView) {
        moviesRepository.getPopular(new MoviesDataSource.GetMoviesCallback() {
            @Override
            public void onMoviesLoaded(List<Movie> movies) {
                recyclerView.setAdapter(new PopularAdapter(movies, new PopularViewModel(application, moviesRepository), application));
                LinearLayoutManager layoutManager = new LinearLayoutManager(application);
                layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                recyclerView.setLayoutManager(layoutManager);

            }

            @Override
            public void onDataNotAvailable() {

            }

            @Override
            public void onError(String errorMessage) {

            }
        });
    }


}
