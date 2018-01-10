package com.nacoda.moviesmvvm.data.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Mayburger on 1/9/18.
 */

public final class Movie implements Serializable {
    private int vote_count;
    private int id;
    private boolean isVideo;
    private double vote_average;
    private String title;
    private String popularity;
    private String poster_path;

    public int getVote_count() {
        return vote_count;
    }

    public int getId() {
        return id;
    }

    public boolean isVideo() {
        return isVideo;
    }

    public double getVote_average() {
        return vote_average;
    }

    public String getTitle() {
        return title;
    }

    public String getPopularity() {
        return popularity;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public boolean isAdult() {
        return isAdult;
    }

    public String getOverview() {
        return overview;
    }

    public String getRelease_date() {
        return release_date;
    }

    public ArrayList<String> getGenre_ids() {
        return genre_ids;
    }

    private String original_language;
    private String original_title;
    private String backdrop_path;
    private boolean isAdult;
    private String overview;
    private String release_date;
    private ArrayList<String> genre_ids;

}
