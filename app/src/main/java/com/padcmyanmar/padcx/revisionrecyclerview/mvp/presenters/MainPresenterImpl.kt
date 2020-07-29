package com.padcmyanmar.padcx.revisionrecyclerview.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.padcmyanmar.padcx.revisionrecyclerview.data.models.NewsModel
import com.padcmyanmar.padcx.revisionrecyclerview.data.models.NewsModelImpl
import com.padcmyanmar.padcx.revisionrecyclerview.mvp.views.MainView


abstract class MainPresenterImpl : MainPresenter,AbstractBasePresenter<MainView>() {

    var mNewsModel  : NewsModel = NewsModelImpl

    override fun onTapItemNews(dataId : String) {
        mView?.navigateToDetailScreen(dataId)
    }

    protected fun requestData(lifecycleOwner: LifecycleOwner){
        mView?.disableSwipeRefresh()
        mNewsModel.getAllNews(onError = {
            mView?.enableSwipeRefresh()
        }).observe(lifecycleOwner,Observer{
                mView?.disableSwipeRefresh()
                if (it.isEmpty()){
                    mView?.showEmptyPod()
                }else{
                    mView?.showDataList(it)
                }

        })
    }

    override fun onSwipeRefresh(lifecycleOwner: LifecycleOwner) {
        requestData(lifecycleOwner)
    }

    override fun onUiReady(lifecycleOwner: LifecycleOwner) {
        requestData(lifecycleOwner)
    }


    override fun onTapNewsDetail(dataId: String) {
        mView?.navigateToDetailScreen(dataId)
    }

    override fun onTapLike() {

    }
}