package com.nacoda.moviesmvvm.mvvm.main.movies.top;

import android.annotation.SuppressLint;
import android.arch.lifecycle.ViewModel;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nacoda.moviesmvvm.base.BaseFragment;
import com.nacoda.moviesmvvm.databinding.PopularFragmentBinding;
import com.nacoda.moviesmvvm.databinding.TopFragmentBinding;
import com.nacoda.moviesmvvm.mvvm.main.movies.popular.PopularViewModel;
import com.nacoda.moviesmvvm.util.MoviesExt;

import org.jetbrains.annotations.NotNull;

import kotlin.TypeCastException;

/**
 * Created by Mayburger on 1/10/18.
 */

@SuppressLint("ValidFragment")
public class TopFragment extends BaseFragment {

    TopFragmentBinding mViewDataBinding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mViewDataBinding = TopFragmentBinding.inflate(inflater, container, false);
        mViewDataBinding.setMViewModel(obtainViewModel());
        return mViewDataBinding.getRoot();

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewDataBinding.getMViewModel().start(mViewDataBinding.recyclerViewMain);
    }

    private final TopViewModel obtainViewModel() {
        ViewModel viewModel = MoviesExt.obtainViewModel((Fragment) this, TopViewModel.class);
        if (viewModel == null) {
            throw new TypeCastException("null");
        } else {
            return (TopViewModel) viewModel;
        }
    }

    public static final class Companion {
        @NotNull
        public final TopFragment newInstance() {
            return new TopFragment();
        }
    }
}
