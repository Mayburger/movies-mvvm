package com.nacoda.moviesmvvm.mvvm.detail.casts;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.nacoda.moviesmvvm.R;
import com.nacoda.moviesmvvm.data.model.Casts;
import com.nacoda.moviesmvvm.databinding.CastsMoviesItemBinding;
import com.nacoda.moviesmvvm.util.helper.Statics;

import org.jetbrains.annotations.NotNull;

import kotlin.jvm.internal.Intrinsics;

/**
 * Created by Mayburger on 1/10/18.
 */

public class CastsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Casts mCasts;
    private CastsViewModel mCastsViewModel;
    private Context mContext;

    public CastsAdapter(Casts mCasts, CastsViewModel mCastsViewModel, Context mContext) {
        this.mCasts = mCasts;
        this.mCastsViewModel = mCastsViewModel;
        this.mContext = mContext;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CastsMoviesItemBinding mItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.casts_movies_item, parent, false);

        return new ItemHolder(mItemBinding);

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Casts.Cast mItem = mCasts.getCast().get(position);
        ItemHolder itemHolder = (ItemHolder) holder;
        itemHolder.bindItem(mItem);

    }

    @Override
    public int getItemCount() {
        return mCasts.getCast().size();
    }

    class ItemHolder extends RecyclerView.ViewHolder {

        CastsMoviesItemBinding mItemBinding;

        ItemHolder(CastsMoviesItemBinding itemView) {
            super(itemView.getRoot());
            this.mItemBinding = itemView;
        }

        final void bindItem(@NotNull Casts.Cast casts) {
            Intrinsics.checkParameterIsNotNull(casts, "casts");
            this.mItemBinding.setCasts(casts);
            this.mItemBinding.setProfilePath(Statics.IMAGE_URL + casts.getProfile_path());
            this.mItemBinding.setCharacter("as " + casts.getCharacter());
            this.mItemBinding.executePendingBindings();
        }


    }

}
