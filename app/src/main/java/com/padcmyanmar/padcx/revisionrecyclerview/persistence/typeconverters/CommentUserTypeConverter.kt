package com.padcmyanmar.padcx.revisionrecyclerview.persistence.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.padcmyanmar.padcx.revisionrecyclerview.data.vos.CommentsVO

class CommentUserTypeConverter {

    @TypeConverter
    fun toString(commentUserList : ArrayList<CommentsVO>):String{
        return Gson().toJson(commentUserList)
    }

    @TypeConverter
    fun toCommentList(commentUserJsonString : String) : ArrayList<CommentsVO>{
        val commentUserListType = object : TypeToken<ArrayList<CommentsVO>>() {}.type
        return Gson().fromJson(commentUserJsonString,commentUserListType)
    }
}

