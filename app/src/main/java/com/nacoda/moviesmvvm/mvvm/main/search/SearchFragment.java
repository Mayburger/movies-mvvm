package com.nacoda.moviesmvvm.mvvm.main.search;

import android.annotation.SuppressLint;
import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableInt;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.nacoda.moviesmvvm.base.BaseFragment;
import com.nacoda.moviesmvvm.databinding.SearchFragmentBinding;
import com.nacoda.moviesmvvm.mvvm.main.MainMoviesActivity;
import com.nacoda.moviesmvvm.util.MoviesExt;
import com.nacoda.moviesmvvm.util.helper.Helper;

import org.jetbrains.annotations.NotNull;

import kotlin.TypeCastException;

/**
 * Created by Mayburger on 1/10/18.
 */

@SuppressLint("ValidFragment")
public class SearchFragment extends BaseFragment {

    SearchFragmentBinding mViewDataBinding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mViewDataBinding = SearchFragmentBinding.inflate(inflater, container, false);
        mViewDataBinding.setMViewModel(obtainViewModel());
        return mViewDataBinding.getRoot();

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewDataBinding.getMViewModel().progressVisibility = new ObservableInt();
        mViewDataBinding.getMViewModel().recyclerVisibility = new ObservableInt();
        mViewDataBinding.getMViewModel().errorTextVisibility = new ObservableInt();

        YoYo.with(Techniques.SlideInUp)
                .duration(300)
                .playOn(mViewDataBinding.search);

        Helper.hideProgress(mViewDataBinding.getMViewModel().progressVisibility, mViewDataBinding.getMViewModel().recyclerVisibility, mViewDataBinding.getMViewModel().errorTextVisibility);

        mViewDataBinding.search.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH){
                    ((MainMoviesActivity)getActivity()).hideInputMethod();

                    Helper.onSearchStarted(mViewDataBinding.getMViewModel().progressVisibility, mViewDataBinding.getMViewModel().errorTextVisibility);

                    mViewDataBinding.getMViewModel().start(mViewDataBinding.search.getText().toString(), mViewDataBinding.recyclerViewSearch);
                }
                return true;
            }
        });
    }

    private final SearchViewModel obtainViewModel() {
        ViewModel viewModel = MoviesExt.obtainViewModel((Fragment) this, SearchViewModel.class);
        if (viewModel == null) {
            throw new TypeCastException("null");
        } else {
            return (SearchViewModel) viewModel;
        }
    }

    public static final class Companion {
        @NotNull
        public final SearchFragment newInstance() {
            return new SearchFragment();
        }
    }
}
