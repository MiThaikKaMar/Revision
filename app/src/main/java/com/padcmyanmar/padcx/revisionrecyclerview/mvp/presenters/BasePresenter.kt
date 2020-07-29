package com.padcmyanmar.padcx.revisionrecyclerview.mvp.presenters

import com.padcmyanmar.padcx.revisionrecyclerview.mvp.views.BaseView

interface BasePresenter<T : BaseView> {
    fun onCreate()
    fun onStart()
    fun onResume()
    fun onPause()
    fun onStop()
    fun onDestroy()
    fun initPresenter(view : T)
}