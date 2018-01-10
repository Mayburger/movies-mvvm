package com.nacoda.moviesmvvm.mvvm.detail.casts;

import android.annotation.SuppressLint;
import android.arch.lifecycle.ViewModel;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nacoda.moviesmvvm.base.BaseFragment;
import com.nacoda.moviesmvvm.data.model.Movie;
import com.nacoda.moviesmvvm.databinding.CastsFragmentBinding;
import com.nacoda.moviesmvvm.databinding.CastsMoviesItemBinding;
import com.nacoda.moviesmvvm.util.MoviesExt;
import com.nacoda.moviesmvvm.util.ViewModelFactory;

import org.jetbrains.annotations.NotNull;

import kotlin.TypeCastException;

/**
 * Created by Mayburger on 1/10/18.
 */

@SuppressLint("ValidFragment")
public class CastsFragment extends BaseFragment {

    Movie mMovie;

    public CastsFragment(Movie mMovie) {
        this.mMovie = mMovie;
    }

    CastsFragmentBinding mViewDataBinding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mViewDataBinding = CastsFragmentBinding.inflate(inflater, container, false);
        mViewDataBinding.setMViewModel(obtainViewModel());
        return mViewDataBinding.getRoot();

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewDataBinding.getMViewModel().start(mMovie, mViewDataBinding.recyclerViewCasts);
    }

    private final CastsViewModel obtainViewModel() {
        ViewModel viewModel = MoviesExt.obtainViewModel((Fragment) this, CastsViewModel.class);
        if (viewModel == null) {
            throw new TypeCastException("null");
        } else {
            return (CastsViewModel) viewModel;
        }
    }

    public static final class Companion {
        @NotNull
        public final CastsFragment newInstance(@NotNull Movie mMovie) {
            return new CastsFragment(mMovie);
        }
    }
}
