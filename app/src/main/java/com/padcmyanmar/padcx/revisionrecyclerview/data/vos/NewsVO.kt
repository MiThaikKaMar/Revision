package com.padcmyanmar.padcx.revisionrecyclerview.data.vos

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import com.padcmyanmar.padcx.revisionrecyclerview.persistence.typeconverters.CommentUserTypeConverter
import com.padcmyanmar.padcx.revisionrecyclerview.persistence.typeconverters.LikeUserTypeConverter

@Entity(tableName ="news")
@TypeConverters(LikeUserTypeConverter::class,CommentUserTypeConverter::class)
data class NewsVO (
    @PrimaryKey
    @SerializedName("id") var id : String= "",
    @SerializedName("title") var title : String ="",
    @SerializedName("hero_image") var heroImage : String = "",
    @SerializedName("description") var description : String = "",
    @Embedded
    @SerializedName("publication") var publication : PublicationVO? =null,
    @SerializedName("liked_users") var likedUsers : ArrayList<LikedUsersVO> = arrayListOf(),
    @SerializedName("comments") var comments : ArrayList<CommentsVO> = arrayListOf()
)