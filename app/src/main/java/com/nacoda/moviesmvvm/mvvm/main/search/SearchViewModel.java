package com.nacoda.moviesmvvm.mvvm.main.search;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.databinding.ObservableInt;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.nacoda.moviesmvvm.data.model.Movie;
import com.nacoda.moviesmvvm.data.source.MoviesDataSource;
import com.nacoda.moviesmvvm.data.source.MoviesRepository;

import java.util.List;

import static com.nacoda.moviesmvvm.util.helper.Helper.hideProgress;
import static com.nacoda.moviesmvvm.util.helper.Helper.showProgress;

/**
 * Created by Mayburger on 1/9/18.
 */

public class SearchViewModel extends AndroidViewModel {

    private MoviesRepository moviesRepository;
    private Application application;

    public ObservableInt progressVisibility;
    public ObservableInt recyclerVisibility;
    public ObservableInt errorTextVisibility;

    public SearchViewModel(@NonNull Application application, MoviesRepository moviesRepository) {
        super(application);
        this.moviesRepository = moviesRepository;
        this.application = application;
    }

    public void start(String query, RecyclerView recyclerView) {
        progressVisibility = new ObservableInt();
        recyclerVisibility = new ObservableInt();
        errorTextVisibility = new ObservableInt();

        moviesRepository.getSearch(new MoviesDataSource.GetMoviesCallback() {
            @Override
            public void onMoviesLoaded(List<Movie> movies) {

                showProgress(progressVisibility,recyclerVisibility,errorTextVisibility);

                recyclerView.setAdapter(new SearchAdapter(movies,new SearchViewModel(application,moviesRepository),application));
                recyclerView.setLayoutManager(new LinearLayoutManager(application));

                hideProgress(progressVisibility, recyclerVisibility, errorTextVisibility);
            }

            @Override
            public void onDataNotAvailable() {
                hideProgress(progressVisibility, recyclerVisibility, errorTextVisibility);
            }

            @Override
            public void onError(String errorMessage) {
                hideProgress(progressVisibility, recyclerVisibility);
            }
        }, query);
    }


}
