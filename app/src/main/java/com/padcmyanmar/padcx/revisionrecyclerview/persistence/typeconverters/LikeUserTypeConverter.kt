package com.padcmyanmar.padcx.revisionrecyclerview.persistence.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.padcmyanmar.padcx.revisionrecyclerview.data.vos.LikedUsersVO

class LikeUserTypeConverter {

    @TypeConverter
    fun toString(likeUserList : ArrayList<LikedUsersVO>):String{
        return Gson().toJson(likeUserList)
    }

    @TypeConverter
    fun toUserList(likeUserJsonString : String) : ArrayList<LikedUsersVO>{
        val likeUserListType = object : TypeToken<ArrayList<LikedUsersVO>>() {} .type
        return Gson().fromJson(likeUserJsonString,likeUserListType)
    }
}