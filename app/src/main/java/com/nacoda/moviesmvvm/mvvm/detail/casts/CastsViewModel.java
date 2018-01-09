package com.nacoda.moviesmvvm.mvvm.detail.casts;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.databinding.ObservableInt;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.nacoda.moviesmvvm.data.model.Casts;
import com.nacoda.moviesmvvm.data.model.Movie;
import com.nacoda.moviesmvvm.data.source.MoviesDataSource;
import com.nacoda.moviesmvvm.data.source.MoviesRepository;
import com.nacoda.moviesmvvm.util.helper.Helper;

import static com.nacoda.moviesmvvm.util.helper.Helper.hideProgress;
import static com.nacoda.moviesmvvm.util.helper.Helper.showProgress;

/**
 * Created by Mayburger on 1/9/18.
 */

public class CastsViewModel extends AndroidViewModel {

    private MoviesRepository moviesRepository;
    private Application application;

    public ObservableInt progressVisibility;
    public ObservableInt recyclerVisibility;
    public ObservableInt errorTextVisibility;

    public CastsViewModel(@NonNull Application application, MoviesRepository moviesRepository) {
        super(application);
        this.moviesRepository = moviesRepository;
        this.application = application;
    }

    public void start(Movie movie, RecyclerView recyclerView) {
        progressVisibility = new ObservableInt();
        recyclerVisibility = new ObservableInt();
        errorTextVisibility = new ObservableInt();

        getCasts(movie, recyclerView);
    }

    void getCasts(Movie movie, RecyclerView recyclerView) {
        moviesRepository.getCasts(new MoviesDataSource.GetCastsCallback() {
            @Override
            public void onCastsLoaded(Casts casts) {
                showProgress(progressVisibility, recyclerVisibility,errorTextVisibility);

                recyclerView.setAdapter(new CastsAdapter(casts, new CastsViewModel(application, moviesRepository), application));
                recyclerView.setLayoutManager(new LinearLayoutManager(application));

                hideProgress(progressVisibility, errorTextVisibility);
            }

            @Override
            public void onDataNotAvailable() {
                hideProgress(progressVisibility, recyclerVisibility, errorTextVisibility);
            }

            @Override
            public void onError(String errorMessage) {
                hideProgress(progressVisibility, recyclerVisibility);
            }
        }, String.valueOf(movie.getId()));
    }


}
