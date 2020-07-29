package com.padcmyanmar.padcx.revisionrecyclerview.data.models


import android.content.Context
import com.padcmyanmar.padcx.revisionrecyclerview.network.NewsApi
import com.padcmyanmar.padcx.revisionrecyclerview.persistence.db.NewsDB
import com.padcmyanmar.padcx.revisionrecyclerview.utils.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

abstract class BaseModel{

    var mNewsApi: NewsApi
    protected lateinit var mNewsDB : NewsDB
    init {
        var mOkHttpClient = OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .build()

        var retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(mOkHttpClient)
            .build()

       mNewsApi =retrofit.create(NewsApi::class.java)
    }

    fun initDataBase(context: Context){
        mNewsDB= NewsDB.newDBInstance(context)
    }
}