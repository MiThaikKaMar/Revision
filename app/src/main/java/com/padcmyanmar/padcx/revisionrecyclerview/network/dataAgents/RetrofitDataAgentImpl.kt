//package com.padcmyanmar.padcx.revisionrecyclerview.network.dataAgents
//
//import com.padcmyanmar.padcx.revisionrecyclerview.data.vos.NewsVO
//import com.padcmyanmar.padcx.revisionrecyclerview.network.NewsApi
//import com.padcmyanmar.padcx.revisionrecyclerview.network.responses.GetAllNewsResponse
//import com.padcmyanmar.padcx.revisionrecyclerview.utils.BASE_URL
//import com.padcmyanmar.padcx.revisionrecyclerview.utils.EM_INTERNET_CONNECTION
//import okhttp3.OkHttpClient
//import retrofit2.Call
//import retrofit2.Callback
//import retrofit2.Response
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//import java.util.concurrent.TimeUnit
//
//object RetrofitDataAgentImpl : NewsDataAgent {
//
//    private var mNewsApi : NewsApi? =null
//
//
//    override fun getAllNews(
//        accessToken: String,
//        onSuccess: (ArrayList<NewsVO>) -> Unit,
//        onFailure: (String) -> Unit
//    ) {
//
//        val getAllNewsResponseCall = mNewsApi?.getAllNews(accessToken)
//        getAllNewsResponseCall?.enqueue(object : Callback<GetAllNewsResponse>{
//            override fun onFailure(call: Call<GetAllNewsResponse>, t: Throwable) {
//
//                onFailure.invoke(t.message ?: EM_INTERNET_CONNECTION)
//            }
//
//            override fun onResponse(
//                call: Call<GetAllNewsResponse>,
//                response: Response<GetAllNewsResponse>
//            ) {
//
//                var getAllNewsResponse = response.body()
//                if (getAllNewsResponse != null ){
//                    if(getAllNewsResponse.isResponseOk()){
//
//                        getAllNewsResponse.data.let {
//                            onSuccess.invoke(getAllNewsResponse.data)
//                        }
//                    }else{
//                        onFailure.invoke(getAllNewsResponse.message)
//                    }
//                }else{
//
//                    onFailure(EM_INTERNET_CONNECTION)
//                }
//            }
//
//        })
//    }
//
//
//}