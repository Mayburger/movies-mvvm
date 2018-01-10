package com.nacoda.moviesmvvm.mvvm.main.movies.popular;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.provider.SyncStateContract;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.nacoda.moviesmvvm.R;
import com.nacoda.moviesmvvm.data.model.Casts;
import com.nacoda.moviesmvvm.data.model.Movie;
import com.nacoda.moviesmvvm.databinding.MainMoviesItemBinding;
import com.nacoda.moviesmvvm.mvvm.detail.DetailActivity;
import com.nacoda.moviesmvvm.mvvm.detail.casts.CastsViewModel;
import com.nacoda.moviesmvvm.mvvm.main.MainItemUserActionListener;
import com.nacoda.moviesmvvm.util.helper.Helper;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import kotlin.jvm.internal.Intrinsics;

import static com.nacoda.moviesmvvm.util.helper.Statics.IMAGE_URL;

/**
 * Created by Mayburger on 1/10/18.
 */

public class PopularAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public PopularAdapter(List<Movie> mMovies, PopularViewModel mViewModel, Context mContext) {
        this.mMovies = mMovies;
        this.mViewModel = mViewModel;
        this.mContext = mContext;
    }

    private List<Movie> mMovies;
    private PopularViewModel mViewModel;
    private Context mContext;


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MainMoviesItemBinding mItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.main_movies_item, parent, false);

        return new ItemHolder(mItemBinding);

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Movie item = mMovies.get(position);
        ItemHolder itemHolder = (ItemHolder) holder;

        MainItemUserActionListener userActionListener = movie -> {
            Intent intent = new Intent(mContext, DetailActivity.class);
            intent.putExtra(mContext.getString(R.string.detail_intent), movie);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            mContext.startActivity(intent);
        };

        itemHolder.bindItem(item, userActionListener);
    }

    @Override
    public int getItemCount() {
        return mMovies.size();
    }

    class ItemHolder extends RecyclerView.ViewHolder {

        MainMoviesItemBinding mItemBinding;

        ItemHolder(MainMoviesItemBinding itemView) {
            super(itemView.getRoot());
            this.mItemBinding = itemView;
        }

        final void bindItem(Movie movie, MainItemUserActionListener userActionListener) {
            mItemBinding.setItem(movie);
            mItemBinding.setUserActionListener(userActionListener);
            mItemBinding.setGenres(Helper.getGenres(movie.getGenre_ids()));
            mItemBinding.setPosterPath((IMAGE_URL + movie.getPoster_path()));
            mItemBinding.executePendingBindings();
        }


    }

}
