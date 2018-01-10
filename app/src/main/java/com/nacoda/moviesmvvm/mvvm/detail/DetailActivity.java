package com.nacoda.moviesmvvm.mvvm.detail;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.nacoda.moviesmvvm.R;
import com.nacoda.moviesmvvm.base.BaseActivity;
import com.nacoda.moviesmvvm.data.model.Movie;
import com.nacoda.moviesmvvm.util.MoviesExt;

import org.jetbrains.annotations.Nullable;

import java.io.Serializable;
import java.util.HashMap;

import kotlin.TypeCastException;

/**
 * Created by Mayburger on 1/10/18.
 */

public final class DetailActivity extends BaseActivity {
    private HashMap _$_findViewCache;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.detail_activity);
        this.setupFragment();
    }

    private final void setupFragment() {
        getSupportFragmentManager().findFragmentById(R.id.detail_header_frame);
        Serializable movies = this.getIntent().getSerializableExtra(this.getString(R.string.detail_intent));
        MoviesExt.replaceFragmentInActivity(this, (Fragment)DetailFragment.Companion.newInstance((Movie)movies),R.id.detail_header_frame);
    }
}