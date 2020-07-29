package com.padcmyanmar.padcx.revisionrecyclerview.data.vos

import com.google.gson.annotations.SerializedName

data class CommentsVO (
    @SerializedName("id") var id : String="",
    @SerializedName("comment_message") var commentMessage : String = "",
    @SerializedName("commented_user") var commentedUser : LikedUsersVO? = null
)