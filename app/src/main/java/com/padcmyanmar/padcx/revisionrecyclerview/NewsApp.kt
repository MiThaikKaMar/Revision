package com.padcmyanmar.padcx.revisionrecyclerview

import android.app.Application
import com.padcmyanmar.padcx.revisionrecyclerview.data.models.NewsModelImpl

class NewsApp : Application() {


    override fun onCreate() {
        super.onCreate()
        NewsModelImpl.initDataBase(applicationContext)

    }

}