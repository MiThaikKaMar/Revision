package com.padcmyanmar.padcx.revisionrecyclerview.data.vos

import com.google.gson.annotations.SerializedName

data class LikedUsersVO (
    @SerializedName("id") var id : String = "",
    @SerializedName("user_name") var userName : String = "",
    @SerializedName("email") var email : String=""
)