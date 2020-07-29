package com.padcmyanmar.padcx.revisionrecyclerview.activities

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.padcmyanmar.padcx.revisionrecyclerview.R
import com.padcmyanmar.padcx.revisionrecyclerview.adapters.NewsListAdapter
import com.padcmyanmar.padcx.revisionrecyclerview.data.vos.NewsVO
import com.padcmyanmar.padcx.revisionrecyclerview.delegates.NewsItemDelegate
import com.padcmyanmar.padcx.revisionrecyclerview.mvp.presenters.MainPresenter
import com.padcmyanmar.padcx.revisionrecyclerview.mvp.presenters.MainPresenterImpl
import com.padcmyanmar.padcx.revisionrecyclerview.mvp.views.MainView
import com.padcmyanmar.padcx.revisionrecyclerview.views.viewPods.EmptyViewPod


import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), MainView {

    protected lateinit var mAdapter: NewsListAdapter
    private lateinit var mEmpytViewPod: EmptyViewPod
    private lateinit var mMainPresenter: MainPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)


        setUpPresenter()
        setUpEmptyViewPod()
        setUpSwipeRefresh()
        setUpRecyclerView()
        mMainPresenter.onUiReady(this)

    }

    private fun setUpPresenter() {
        mMainPresenter = ViewModelProviders.of(this).get(MainPresenterImpl::class.java)
        mMainPresenter.initPresenter(this)
    }

    override fun showEmptyPod() {
        vp_empty.visibility = View.VISIBLE
    }

    override fun hideEmptyPod() {
        vp_empty.visibility = View.GONE
    }

    override fun enableSwipeRefresh() {
        swipeRefreshLayout.isRefreshing = true
    }

    override fun disableSwipeRefresh() {
        swipeRefreshLayout.isRefreshing = false
    }

    override fun showDataList(newsList: List<NewsVO>) {
        mAdapter.setNewData(newsList.toMutableList())
    }


    override fun navigateToDetailScreen(dataId: String) {
        startActivity(NewsDetailActivity.newIntent(this, dataId))
    }

    private fun setUpEmptyViewPod() {
        mEmpytViewPod = vp_empty as EmptyViewPod
        mEmpytViewPod.setEmptyData(
            "There is test set Empty Data",
            "https://images.unsplash.com/photo-1510936111840-65e151ad71bb?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&w=1000&q=80"
        )
    }

    private fun setUpSwipeRefresh() {
        swipeRefreshLayout.setOnRefreshListener {
            mMainPresenter.onSwipeRefresh(this)
        }
    }

    private fun setUpRecyclerView() {
        mAdapter = NewsListAdapter(mMainPresenter)
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rv_news.adapter = mAdapter
        rv_news.layoutManager = layoutManager
    }

}


