package com.nacoda.moviesmvvm.mvvm.main.search

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.nacoda.moviesmvvm.R
import com.nacoda.moviesmvvm.data.model.Movie
import com.nacoda.moviesmvvm.databinding.SearchMoviesItemBinding
import com.nacoda.moviesmvvm.mvvm.detail.DetailActivity
import com.nacoda.moviesmvvm.mvvm.main.MainItemUserActionListener
import com.nacoda.moviesmvvm.util.helper.Helper.getGenres
import com.nacoda.moviesmvvm.util.helper.Statics.IMAGE_URL

/**
 * Created by irfanirawansukirman on 04/12/17.
 */

class SearchAdapter(private var mMovies: List<Movie>?, private var mSearchViewModel: SearchViewModel, var mContext: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        val mMainItemBinding: SearchMoviesItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent?.context),
                R.layout.search_movies_item, parent, false)

        return MainItemHolder(mMainItemBinding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        val mMovieItem = mMovies!![position]

        val mUserActionListener = object : MainItemUserActionListener {
            override fun onMovieClicked(movie: Movie) {
                val intent = Intent(mContext, DetailActivity::class.java)
                intent.putExtra(mContext.getString(R.string.detail_intent), movie)
                mContext.startActivity(intent)
            }
        }
        (holder as MainItemHolder).bindItem(mMovieItem, mUserActionListener)
    }

    override fun getItemCount(): Int {
        return mMovies!!.size
    }

    fun replaceData(mMovies: List<Movie>) {
        setList(mMovies)
    }

    fun setList(mMovies: List<Movie>) {
        this.mMovies = mMovies
        notifyDataSetChanged()
    }

    class MainItemHolder(itemView: SearchMoviesItemBinding) : RecyclerView.ViewHolder(itemView.root) {
        private val mMainItemBinding: SearchMoviesItemBinding = itemView

        fun bindItem(movie: Movie, userActionListener: MainItemUserActionListener) {

            mMainItemBinding.item = movie
            mMainItemBinding.userActionListener = userActionListener
            mMainItemBinding.genres = getGenres(movie.genre_ids)
            try {
                mMainItemBinding.year = movie.release_date?.substring(0, 4)
            } catch (e:Exception){
                mMainItemBinding.year = "?"
            }
            mMainItemBinding.votes = movie.vote_count.toString()
            mMainItemBinding.posterPath = (IMAGE_URL + movie.poster_path)
            mMainItemBinding.rating = ((movie.vote_average.toFloat() * 10).toInt().toString() + "%")
            mMainItemBinding.executePendingBindings()


        }
    }


}