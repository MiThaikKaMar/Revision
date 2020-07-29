package com.padcmyanmar.padcx.revisionrecyclerview.data.models

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import com.padcmyanmar.padcx.revisionrecyclerview.data.vos.NewsVO
import com.padcmyanmar.padcx.revisionrecyclerview.mvp.views.MainView
import com.padcmyanmar.padcx.revisionrecyclerview.persistence.db.NewsDB
import com.padcmyanmar.padcx.revisionrecyclerview.utils.DUMMY_ACCESS_TOKEN
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


object NewsModelImpl : BaseModel(), NewsModel {

    @SuppressLint("CheckResult")
    override fun getAllNews(onError : (String) -> Unit): LiveData<List<NewsVO>> {
        mNewsApi.getAllNews(DUMMY_ACCESS_TOKEN)
            .map { it.data.toList() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                mNewsDB.newsDao().insertNewsList(it)
            },{
               Log.e("ERROR",it.toString())
            })
        return mNewsDB.newsDao().getNewsList()
    }

    override fun getNewsById(dataId: String): NewsVO {
        return mNewsDB.newsDao().getNewsById(dataId)
    }
}