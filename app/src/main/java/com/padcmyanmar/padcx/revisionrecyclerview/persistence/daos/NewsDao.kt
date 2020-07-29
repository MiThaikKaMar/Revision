package com.padcmyanmar.padcx.revisionrecyclerview.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.padcmyanmar.padcx.revisionrecyclerview.data.vos.NewsVO

@Dao
interface NewsDao {

    @Query("SELECT * FROM news")
    fun getNewsList() : LiveData<List<NewsVO>>

    @Query("SELECT * FROM news WHERE :newsId")
    fun getNewsById(newsId: String) : NewsVO

    @Delete
    fun deleteNews(news : NewsVO)

    @Query("DELETE FROM news")
    fun deleteAll()

    @Insert
    fun insertNewsList(newsList: List<NewsVO>)

    @Insert
    fun insertNews(news : NewsVO)
}