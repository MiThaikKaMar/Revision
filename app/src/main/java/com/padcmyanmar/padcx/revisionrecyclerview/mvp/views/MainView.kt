package com.padcmyanmar.padcx.revisionrecyclerview.mvp.views

import com.padcmyanmar.padcx.revisionrecyclerview.data.vos.NewsVO

interface MainView : BaseView {
    fun showEmptyPod()
    fun hideEmptyPod()
    fun enableSwipeRefresh()
    fun disableSwipeRefresh()
    fun showDataList(newsList : List<NewsVO>)
    fun navigateToDetailScreen(dataId : String)
}