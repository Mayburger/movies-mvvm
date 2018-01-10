package com.nacoda.moviesmvvm.mvvm.main.search;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.nacoda.moviesmvvm.R;
import com.nacoda.moviesmvvm.data.model.Movie;
import com.nacoda.moviesmvvm.databinding.SearchMoviesItemBinding;
import com.nacoda.moviesmvvm.mvvm.detail.DetailActivity;
import com.nacoda.moviesmvvm.mvvm.main.MainItemUserActionListener;
import com.nacoda.moviesmvvm.util.helper.Helper;

import java.util.List;

import static com.nacoda.moviesmvvm.util.helper.Statics.IMAGE_URL;

/**
 * Created by Mayburger on 1/10/18.
 */

public class SearchAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public SearchAdapter(List<Movie> mMovies, SearchViewModel mViewModel, Context mContext) {
        this.mMovies = mMovies;
        this.mViewModel = mViewModel;
        this.mContext = mContext;
    }

    private List<Movie> mMovies;
    private SearchViewModel mViewModel;
    private Context mContext;


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        SearchMoviesItemBinding mItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.search_movies_item, parent, false);

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

        SearchMoviesItemBinding mItemBinding;

        ItemHolder(SearchMoviesItemBinding itemView) {
            super(itemView.getRoot());
            this.mItemBinding = itemView;
        }

        final void bindItem(Movie movie, MainItemUserActionListener userActionListener) {
            mItemBinding.setItem(movie);
            mItemBinding.setUserActionListener(userActionListener);
            mItemBinding.setGenres(Helper.getGenres(movie.getGenre_ids()));
            try{
                mItemBinding.setYear(movie.getRelease_date().substring(0,4));
            } catch (Exception e){
                mItemBinding.setYear("?");
            }
            mItemBinding.setVotes(String.valueOf(movie.getVote_count()));
            mItemBinding.setPosterPath((IMAGE_URL + movie.getPoster_path()));
            mItemBinding.setRating(((movie.getVote_average() * 10) + "%").replace(".0",""));
            mItemBinding.executePendingBindings();
//            String.valueOf(Integer.parseInt(String.valueOf((Float.parseFloat(String.valueOf(movie.getVote_average())) * 10)))) + "%"



        }


    }

}
