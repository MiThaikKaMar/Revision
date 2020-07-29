package com.padcmyanmar.padcx.revisionrecyclerview.persistence.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.padcmyanmar.padcx.revisionrecyclerview.data.vos.NewsVO
import com.padcmyanmar.padcx.revisionrecyclerview.persistence.daos.NewsDao

@Database(entities = [NewsVO::class], version = 4 , exportSchema = true)
abstract class NewsDB : RoomDatabase(){
    companion object{
        val DB_NAME="NEWS_DB_NAME"
        var dbInstance : NewsDB? = null
        fun newDBInstance(context: Context): NewsDB {
            when(dbInstance){
                null -> {
                    dbInstance= Room.databaseBuilder(context,NewsDB::class.java, DB_NAME)
                        .build()
                }
            }

            val emptyDBInstance = dbInstance
            return emptyDBInstance!!
        }
    }
abstract fun newsDao() : NewsDao
}