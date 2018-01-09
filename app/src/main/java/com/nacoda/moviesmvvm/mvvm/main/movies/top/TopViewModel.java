package com.nacoda.moviesmvvm.mvvm.main.movies.top;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.nacoda.moviesmvvm.data.model.Movie;
import com.nacoda.moviesmvvm.data.source.MoviesDataSource;
import com.nacoda.moviesmvvm.data.source.MoviesRepository;
import com.nacoda.moviesmvvm.mvvm.main.movies.popular.PopularAdapter;
import com.nacoda.moviesmvvm.mvvm.main.movies.popular.PopularViewModel;

import java.util.List;

/**
 * Created by Mayburger on 1/9/18.
 */

public class TopViewModel extends AndroidViewModel {

    private MoviesRepository moviesRepository;
    private Application application;

    public TopViewModel(@NonNull Application application, MoviesRepository moviesRepository) {
        super(application);
        this.application = application;
        this.moviesRepository = moviesRepository;
    }

    public void start(RecyclerView recyclerView) {
        moviesRepository.getTopRated(new MoviesDataSource.GetMoviesCallback() {
            @Override
            public void onMoviesLoaded(List<Movie> movies) {
                recyclerView.setAdapter(new TopAdapter(movies, new TopViewModel(application, moviesRepository), application));
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
