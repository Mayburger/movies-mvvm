package com.nacoda.moviesmvvm.util.helper;

import android.databinding.BindingAdapter;
import android.databinding.ObservableInt;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Mayburger on 1/9/18.
 */

public class Helper {

    public static String getGenres(ArrayList<String> data) {
        return String.valueOf(data)
                .replace("28", "Action").replace("27", "Horror").replace("12", "Adventure").replace("16", "Animation").replace("35", "Comedy").replace("80", "Crime").replace("99", "Documentary").replace("18", "Drama").replace("14", "Fantasy").replace("10402", "Music").replace("9648", "Mystery").replace("10749", "Romance").replace("878", "Science Fiction").replace("10770", "TV Movie").replace("10752", "War").replace("37", "Western").replace("10751", "Family").replace("53", "Thriller").replace("[", "").replace("]", "");
    }

    public static void showProgress(ObservableInt progressVisibility, ObservableInt recyclerVisibility, ObservableInt errorTextVisibility) {
        progressVisibility.set(View.VISIBLE);
        recyclerVisibility.set(View.GONE);
        errorTextVisibility.set(View.GONE);
    }

    public static void hideProgress(ObservableInt progressVisibility, ObservableInt recyclerVisibility) {
        progressVisibility.set(View.GONE);
        recyclerVisibility.set(View.VISIBLE);
    }

    public static void hideProgress(ObservableInt progressVisibility, ObservableInt recyclerVisibility, ObservableInt errorTextVisibility) {
        progressVisibility.set(View.GONE);
        recyclerVisibility.set(View.VISIBLE);
        errorTextVisibility.set(View.VISIBLE);
    }

    public static void onSearchStarted(ObservableInt progressVisibility, ObservableInt errorTextVisibility) {
        progressVisibility.set(View.VISIBLE);
        errorTextVisibility.set(View.GONE);
    }

    @BindingAdapter("bind:loadPoster")
    public static void loadPoster(ImageView view, String url) {
        Glide.with(view.getContext()).load(url).apply(new RequestOptions().centerCrop()).transition(DrawableTransitionOptions.withCrossFade()).into(view);
    }
}
