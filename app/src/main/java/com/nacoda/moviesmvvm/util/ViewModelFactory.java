package com.nacoda.moviesmvvm.util;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;

import com.nacoda.moviesmvvm.data.source.MoviesRepository;
import com.nacoda.moviesmvvm.mvvm.detail.DetailViewModel;
import com.nacoda.moviesmvvm.mvvm.detail.casts.CastsViewModel;
import com.nacoda.moviesmvvm.mvvm.detail.info.InfoViewModel;
import com.nacoda.moviesmvvm.mvvm.main.movies.popular.PopularViewModel;
import com.nacoda.moviesmvvm.mvvm.main.movies.top.TopViewModel;
import com.nacoda.moviesmvvm.mvvm.main.search.SearchViewModel;

import org.jetbrains.annotations.NotNull;

import kotlin.jvm.internal.Intrinsics;


/**
 * Created by Mayburger on 1/9/18.
 */

public class ViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private final Application mApplication;
    private final MoviesRepository mMoviesRepository;
    private static volatile ViewModelFactory INSTANCE;

    public ViewModelFactory(Application mApplication, MoviesRepository mMoviesRepository) {
        this.mApplication = mApplication;
        this.mMoviesRepository = mMoviesRepository;
    }

    public ViewModel create(@NotNull Class modelClass) {
        Intrinsics.checkParameterIsNotNull(modelClass, "modelClass");
        AndroidViewModel androidViewModel;
        if (modelClass.isAssignableFrom(PopularViewModel.class)) {
            androidViewModel = (AndroidViewModel) (new PopularViewModel(this.mApplication, this.mMoviesRepository));
        } else if (modelClass.isAssignableFrom(TopViewModel.class)) {
            androidViewModel = (AndroidViewModel) (new TopViewModel(this.mApplication, this.mMoviesRepository));
        } else if (modelClass.isAssignableFrom(SearchViewModel.class)) {
            androidViewModel = (AndroidViewModel) (new SearchViewModel(this.mApplication, this.mMoviesRepository));
        } else if (modelClass.isAssignableFrom(DetailViewModel.class)) {
            androidViewModel = (AndroidViewModel) (new DetailViewModel(this.mApplication, this.mMoviesRepository));
        } else if (modelClass.isAssignableFrom(InfoViewModel.class)) {
            androidViewModel = (AndroidViewModel) (new InfoViewModel(this.mApplication, this.mMoviesRepository));
        } else {
            androidViewModel = (AndroidViewModel) (new CastsViewModel(this.mApplication, this.mMoviesRepository));
        }
        return (ViewModel) androidViewModel;
    }

    public static final class Companion {
        @NotNull
        public final ViewModelFactory getInstance(Application mApplication) {
            Intrinsics.checkParameterIsNotNull(mApplication, "mApplication");
            ViewModelFactory var10000 = ViewModelFactory.INSTANCE;
            if (var10000 == null) {
                Class var2 = ViewModelFactory.class;
                synchronized (var2) {
                }

                ViewModelFactory var4;
                var10000 = ViewModelFactory.INSTANCE;
                if (var10000 == null) {
                    Injection var10003 = Injection.INSTANCE;
                    Context var10004 = mApplication.getApplicationContext();
                    Intrinsics.checkExpressionValueIsNotNull(var10004, "mApplication.applicationContext");
                    ViewModelFactory var3 = new ViewModelFactory(mApplication, var10003.provideMoviesRepository(var10004));
                    ViewModelFactory.INSTANCE = var3;
                    var10000 = var3;
                }

                var4 = var10000;
                var10000 = var4;
            }

            return var10000;
        }


    }
}
