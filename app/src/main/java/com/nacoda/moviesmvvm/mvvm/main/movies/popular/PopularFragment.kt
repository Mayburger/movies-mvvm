package com.nacoda.moviesmvvm.mvvm.main.movies.popular

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nacoda.moviesmvvm.base.BaseFragment
import com.nacoda.moviesmvvm.databinding.PopularFragmentBinding
import com.nacoda.moviesmvvm.util.MoviesExt
import kotlinx.android.synthetic.main.popular_fragment.*

class PopularFragment : BaseFragment() {

    private lateinit var mViewDataBinding: PopularFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        mViewDataBinding = PopularFragmentBinding.inflate(inflater, container, false).apply {
            mViewModel = obtainViewModel()
        }
        return mViewDataBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mViewDataBinding.mViewModel?.start(recyclerViewMain)
    }

    private fun obtainViewModel(): PopularViewModel = MoviesExt.obtainViewModel(this,PopularViewModel::class.java) as PopularViewModel

    companion object {

        fun newInstance() = PopularFragment().apply {

        }
    }
}