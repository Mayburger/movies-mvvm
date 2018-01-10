package com.nacoda.moviesmvvm.mvvm.main.movies.popular;

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
import com.nacoda.moviesmvvm.databinding.PopularFragmentBinding;
import com.nacoda.moviesmvvm.mvvm.detail.casts.CastsViewModel;
import com.nacoda.moviesmvvm.util.MoviesExt;

import org.jetbrains.annotations.NotNull;

import kotlin.TypeCastException;

/**
 * Created by Mayburger on 1/10/18.
 */

@SuppressLint("ValidFragment")
public class PopularFragment extends BaseFragment {

    PopularFragmentBinding mViewDataBinding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mViewDataBinding = PopularFragmentBinding.inflate(inflater, container, false);
        mViewDataBinding.setMViewModel(obtainViewModel());
        return mViewDataBinding.getRoot();

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewDataBinding.getMViewModel().start(mViewDataBinding.recyclerViewMain);
    }

    private final PopularViewModel obtainViewModel() {
        ViewModel viewModel = MoviesExt.obtainViewModel((Fragment) this, PopularViewModel.class);
        if (viewModel == null) {
            throw new TypeCastException("null");
        } else {
            return (PopularViewModel) viewModel;
        }
    }

    public static final class Companion {
        @NotNull
        public final PopularFragment newInstance() {
            return new PopularFragment();
        }
    }
}
