package com.padcmyanmar.padcx.revisionrecyclerview.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.padcmyanmar.padcx.revisionrecyclerview.delegates.NewsItemDelegate
import com.padcmyanmar.padcx.revisionrecyclerview.mvp.views.MainView

interface MainPresenter : BasePresenter<MainView>, NewsItemDelegate {

    fun onTapItemNews(dataId : String)
    fun onSwipeRefresh(lifecycleOwner: LifecycleOwner)
    fun onUiReady(lifecycleOwner: LifecycleOwner)



}