package com.nacoda.moviesmvvm.data.source

import com.nacoda.moviesmvvm.data.model.Casts
import com.nacoda.moviesmvvm.data.model.Detail
import com.nacoda.moviesmvvm.data.model.Movie


/**
 * Created by irfanirawansukirman on 04/12/17.
 */
interface MoviesDataSource {

    /**
     * Get all movie list
     * @param callback
     */
    fun getPopular(callback: GetMoviesCallback)

    fun getNowPlaying(callback: GetMoviesCallback)

    fun getTopRated(callback: GetMoviesCallback)

    fun getSearch(callback: GetMoviesCallback, query: String)

    fun getDetail(callback: GetDetailCallback, movieId: String)

    fun getCasts(callback: GetCastsCallback, movieId: String)

    interface GetDetailCallback {
        fun onDetailLoaded(detail: Detail?)
        fun onDataNotAvailable()
        fun onError(errorMessage: String?)
    }

    interface GetCastsCallback {
        fun onCastsLoaded(casts: Casts)
        fun onDataNotAvailable()
        fun onError(errorMessage: String?)
    }

    interface GetMoviesCallback {

        fun onMoviesLoaded(movies: List<Movie>?)

        fun onDataNotAvailable()

        fun onError(errorMessage: String?)
    }
}