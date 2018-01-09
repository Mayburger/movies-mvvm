package com.nacoda.moviesmvvm.data.source;

import com.nacoda.moviesmvvm.data.model.Casts;
import com.nacoda.moviesmvvm.data.model.Detail;
import com.nacoda.moviesmvvm.data.model.Movie;

import java.util.List;

/**
 * Created by Mayburger on 1/9/18.
 */

public interface MoviesDataSource {

        void getPopular(GetMoviesCallback callback);
        void getNowPlaying(GetMoviesCallback callback);
        void getTopRated(GetMoviesCallback callback);
        void getSearch(GetMoviesCallback callback, String query);
        void getDetail(GetDetailCallback callback, String movieId);
        void getCasts(GetCastsCallback callback, String movieId);


    interface GetMoviesCallback {
        void onMoviesLoaded(List<Movie> movies);
        void onDataNotAvailable();
        void onError(String errorMessage);
    }
    interface GetDetailCallback {
        void onDetailLoaded(Detail detail);
        void onDataNotAvailable();
        void onError(String errorMessage);
    }

    interface GetCastsCallback {
        void onCastsLoaded(Casts casts);
        void onDataNotAvailable();
        void onError(String errorMessage);
    }

}
