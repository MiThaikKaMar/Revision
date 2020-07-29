package com.padcmyanmar.padcx.revisionrecyclerview.network


import androidx.lifecycle.LiveData
import com.padcmyanmar.padcx.revisionrecyclerview.network.responses.GetAllNewsResponse
import com.padcmyanmar.padcx.revisionrecyclerview.utils.GET_NEWS
import com.padcmyanmar.padcx.revisionrecyclerview.utils.PARAM_ACCESS_TOKEN
import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface NewsApi {
    @FormUrlEncoded
    @POST(GET_NEWS)
    fun getAllNews(@Field(PARAM_ACCESS_TOKEN) accessToken : String)
            : Observable<GetAllNewsResponse>
}