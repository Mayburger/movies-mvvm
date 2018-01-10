package com.nacoda.moviesmvvm.mvvm.detail;

import android.annotation.SuppressLint;
import android.arch.lifecycle.ViewModel;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nacoda.moviesmvvm.R;
import com.nacoda.moviesmvvm.base.BaseFragment;
import com.nacoda.moviesmvvm.data.model.Movie;
import com.nacoda.moviesmvvm.databinding.CastsFragmentBinding;
import com.nacoda.moviesmvvm.databinding.DetailFragmentBinding;
import com.nacoda.moviesmvvm.mvvm.detail.casts.CastsFragment;
import com.nacoda.moviesmvvm.mvvm.detail.casts.CastsViewModel;
import com.nacoda.moviesmvvm.mvvm.detail.info.InfoFragment;
import com.nacoda.moviesmvvm.util.MoviesExt;
import com.nacoda.moviesmvvm.util.helper.Helper;

import org.jetbrains.annotations.NotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import kotlin.TypeCastException;

import static com.nacoda.moviesmvvm.util.helper.Statics.IMAGE_URL;

/**
 * Created by Mayburger on 1/10/18.
 */

@SuppressLint("ValidFragment")
public class DetailFragment extends BaseFragment {

    Movie mMovie;

    public DetailFragment(Movie mMovie) {
        this.mMovie = mMovie;
    }

    DetailFragmentBinding mViewDataBinding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mViewDataBinding = DetailFragmentBinding.inflate(inflater, container, false);
        mViewDataBinding.setMViewModel(obtainViewModel());
        return mViewDataBinding.getRoot();

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewDataBinding.setMMovie(mMovie);
        mViewDataBinding.setBackdropPath(IMAGE_URL + mMovie.getBackdrop_path());
        mViewDataBinding.setPosterPath(IMAGE_URL + mMovie.getPoster_path());
        mViewDataBinding.setGenres(Helper.getGenres(mMovie.getGenre_ids()));
        try {
            @SuppressLint("SimpleDateFormat") String date = new SimpleDateFormat("mm dd, yyyy").format(new SimpleDateFormat("yyyy-mm-dd").parse(mMovie.getRelease_date()));
            mViewDataBinding.setReleaseYear(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        mViewDataBinding.tabStrip.setTypeface(Typeface.createFromAsset(getActivity().getAssets(), "fonts/comfortaa_bold.ttf"));

        TabSliderAdapter tabAdapter = new TabSliderAdapter(getFragmentManager());
        tabAdapter.addFragment(new InfoFragment.Companion().newInstance(mMovie), "");
        tabAdapter.addFragment(new CastsFragment.Companion().newInstance(mMovie), "");
        tabAdapter.addFragment(new InfoFragment.Companion().newInstance(mMovie), "");
        mViewDataBinding.viewPager.setAdapter(tabAdapter);
        mViewDataBinding.tabStrip.setViewPager(mViewDataBinding.viewPager,0);
        mViewDataBinding.tabLayout.setTabTextColors(getResources().getColor(R.color.greyIndicator), getResources().getColor(R.color.colorAccent));
        mViewDataBinding.tabLayout.setupWithViewPager(mViewDataBinding.viewPager);



    }

    private final DetailViewModel obtainViewModel() {
        ViewModel viewModel = MoviesExt.obtainViewModel((Fragment) this, DetailViewModel.class);
        if (viewModel == null) {
            throw new TypeCastException("null");
        } else {
            return (DetailViewModel) viewModel;
        }
    }

    public static final class Companion {
        @NotNull
        public static final DetailFragment newInstance(@NotNull Movie mMovie) {
            return new DetailFragment(mMovie);
        }
    }
}
