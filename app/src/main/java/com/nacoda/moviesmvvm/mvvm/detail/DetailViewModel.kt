package com.nacoda.moviesmvvm.mvvm.detail

import android.annotation.SuppressLint
import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import com.nacoda.moviesmvvm.data.source.MoviesRepository

/**
 * Created by irfanirawansukirman on 04/12/17.
 */

class DetailViewModel(context: Application, private val mMoviesRepository: MoviesRepository) : AndroidViewModel(context) {

    @SuppressLint("StaticFieldLeak")
    var mContext = context
}


