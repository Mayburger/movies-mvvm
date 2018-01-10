package com.nacoda.moviesmvvm.mvvm.main.search

import android.databinding.ObservableInt
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nacoda.moviesmvvm.databinding.SearchFragmentBinding
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import com.nacoda.moviesmvvm.base.BaseFragment
import com.nacoda.moviesmvvm.mvvm.main.MainMoviesActivity
import com.nacoda.moviesmvvm.util.MoviesExt
import com.nacoda.moviesmvvm.util.helper.Helper.hideProgress
import com.nacoda.moviesmvvm.util.helper.Helper.onSearchStarted
import kotlinx.android.synthetic.main.search_fragment.*


class SearchFragment : BaseFragment() {

    private lateinit var mViewDataBinding: SearchFragmentBinding
    private lateinit var mAdapter: SearchAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        mViewDataBinding = SearchFragmentBinding.inflate(inflater, container, false).apply {
            mViewModel = obtainViewModel()
        }

        return mViewDataBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        mViewDataBinding.mViewModel!!.progressVisibility = ObservableInt()
        mViewDataBinding.mViewModel!!.recyclerVisibility = ObservableInt()
        mViewDataBinding.mViewModel!!.errorTextVisibility = ObservableInt()

        YoYo.with(Techniques.SlideInUp)
                .duration(300)
                .playOn(search)

        val mViewModel = mViewDataBinding.mViewModel
        (activity as MainMoviesActivity).showInputMethod()

        hideProgress(mViewModel!!.progressVisibility, mViewModel.recyclerVisibility, mViewModel.errorTextVisibility)

        search.setOnEditorActionListener(TextView.OnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                (activity as MainMoviesActivity).hideInputMethod()

                onSearchStarted(mViewModel.progressVisibility, mViewModel.errorTextVisibility)

                mViewDataBinding.mViewModel?.start(search.text.toString(), recyclerViewSearch)
                return@OnEditorActionListener true
            }
            false
        })
    }


    companion object {

        fun newInstance() = SearchFragment().apply {

        }
    }

    private fun obtainViewModel(): SearchViewModel = MoviesExt.obtainViewModel(this,SearchViewModel::class.java) as SearchViewModel
}