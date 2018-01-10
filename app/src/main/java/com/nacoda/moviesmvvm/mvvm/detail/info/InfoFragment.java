package com.nacoda.moviesmvvm.mvvm.detail.info;

import android.annotation.SuppressLint;
import android.arch.lifecycle.ViewModel;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nacoda.moviesmvvm.base.BaseFragment;
import com.nacoda.moviesmvvm.data.model.Movie;
import com.nacoda.moviesmvvm.databinding.CastsFragmentBinding;
import com.nacoda.moviesmvvm.databinding.InfoFragmentBinding;
import com.nacoda.moviesmvvm.mvvm.detail.casts.CastsViewModel;
import com.nacoda.moviesmvvm.util.MoviesExt;

import org.jetbrains.annotations.NotNull;

import kotlin.TypeCastException;

/**
 * Created by Mayburger on 1/10/18.
 */

@SuppressLint("ValidFragment")
public class InfoFragment extends BaseFragment {

    Movie mMovie;

    public InfoFragment(Movie mMovie) {
        this.mMovie = mMovie;
    }

    InfoFragmentBinding mViewDataBinding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mViewDataBinding = InfoFragmentBinding.inflate(inflater, container, false);
        mViewDataBinding.setMViewModel(obtainViewModel());
        return mViewDataBinding.getRoot();

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    private final InfoViewModel obtainViewModel() {
        ViewModel viewModel = MoviesExt.obtainViewModel((Fragment) this, InfoViewModel.class);
        if (viewModel == null) {
            throw new TypeCastException("null");
        } else {
            return (InfoViewModel) viewModel;
        }
    }

    public static final class Companion {
        @NotNull
        public final InfoFragment newInstance(@NotNull Movie mMovie) {
            return new InfoFragment(mMovie);
        }
    }
}
