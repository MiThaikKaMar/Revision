package com.padcmyanmar.padcx.revisionrecyclerview.data.models

import androidx.lifecycle.LiveData
import com.padcmyanmar.padcx.revisionrecyclerview.data.vos.NewsVO
import io.reactivex.Observable

interface NewsModel {
    fun getAllNews(onError : (String) -> Unit): LiveData<List<NewsVO>>
    fun getNewsById(dataId : String) : NewsVO
}