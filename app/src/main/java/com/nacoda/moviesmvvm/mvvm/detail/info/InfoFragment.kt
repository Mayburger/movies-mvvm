package com.nacoda.moviesmvvm.mvvm.detail.info

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nacoda.moviesmvvm.base.BaseFragment
import com.nacoda.moviesmvvm.databinding.InfoFragmentBinding
import com.nacoda.moviesmvvm.util.MoviesExt
import com.nacoda.moviesmvvm.util.ViewModelFactory

class InfoFragment : BaseFragment() {

    private lateinit var mViewDataBinding: InfoFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        mViewDataBinding = InfoFragmentBinding.inflate(inflater, container, false).apply {
            mViewModel = obtainViewModel()
        }

        return mViewDataBinding.root
    }

    private fun obtainViewModel(): InfoViewModel = MoviesExt.obtainViewModel(this,InfoViewModel::class.java) as InfoViewModel

    companion object {

        fun newInstance() = InfoFragment().apply {

        }
    }
}