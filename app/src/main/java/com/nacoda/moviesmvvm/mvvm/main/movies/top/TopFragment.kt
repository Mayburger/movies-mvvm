package com.nacoda.moviesmvvm.mvvm.main.movies.top

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.nacoda.moviesmvvm.base.BaseFragment
import com.nacoda.moviesmvvm.databinding.TopFragmentBinding
import com.nacoda.moviesmvvm.mvvm.main.movies.popular.PopularFragment
import com.nacoda.moviesmvvm.util.MoviesExt
import kotlinx.android.synthetic.main.top_fragment.*

class TopFragment : BaseFragment() {

    private lateinit var mViewDataBinding: TopFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        mViewDataBinding = TopFragmentBinding.inflate(inflater, container, false).apply {
            mViewModel = obtainViewModel()
        }
        return mViewDataBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mViewDataBinding.mViewModel?.start(recyclerViewMain)
    }

    private fun obtainViewModel(): TopViewModel = MoviesExt.obtainViewModel(this, TopViewModel::class.java) as TopViewModel

    companion object {

        fun newInstance() = PopularFragment().apply {

        }
    }
}