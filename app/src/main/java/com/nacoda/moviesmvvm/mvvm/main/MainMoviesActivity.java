package com.nacoda.moviesmvvm.mvvm.main;

import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.nacoda.moviesmvvm.R;
import com.nacoda.moviesmvvm.base.BaseActivity;
import com.nacoda.moviesmvvm.mvvm.main.movies.popular.PopularFragment;
import com.nacoda.moviesmvvm.mvvm.main.movies.top.TopFragment;
import com.nacoda.moviesmvvm.mvvm.main.search.SearchFragment;
import com.nacoda.moviesmvvm.util.MoviesExt;

import kotlin.jvm.internal.Intrinsics;

import static android.view.KeyEvent.KEYCODE_BACK;

/**
 * Created by Mayburger on 1/10/18.
 */

public class MainMoviesActivity extends BaseActivity {

    protected void onCreate(@org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.main_movies_activity);
        this.setupFragment();
    }

    private void setupFragment() {
        this.getSupportFragmentManager().findFragmentById(R.id.movies_frame_popular);
        MoviesExt.replaceFragmentInActivity(this, (Fragment) (new PopularFragment.Companion()).newInstance(), R.id.movies_frame_popular);
        this.getSupportFragmentManager().findFragmentById(R.id.movies_frame_top);
        MoviesExt.replaceFragmentInActivity(this, (Fragment) (new TopFragment.Companion()).newInstance(), R.id.movies_frame_top);
    }

    public void hideInputMethod() {
        // Check if no view has focus:
        View view = getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            assert imm != null;
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    void showInputMethod() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
    }

    void onSearchViewClicked(View view) {
        addFragmentOnTop((Fragment) new SearchFragment.Companion().newInstance(), R.id.search_frame);
    }

    void addFragmentOnTop(Fragment fragment, int layout) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(layout, fragment)
                .addToBackStack("something")
                .commit();
    }
}
