package com.padcmyanmar.padcx.revisionrecyclerview.network.responses

import com.google.gson.annotations.SerializedName
import com.padcmyanmar.padcx.revisionrecyclerview.data.vos.NewsVO
import com.padcmyanmar.padcx.revisionrecyclerview.utils.CODE_RESPONSE_OK

data class GetAllNewsResponse (
    @SerializedName("code") val code : Int =0,
    @SerializedName("message") val message : String ="",
    @SerializedName("data") val data :ArrayList<NewsVO> = arrayListOf()
){
    fun isResponseOk() : Boolean = (code== CODE_RESPONSE_OK && data!=null)
}