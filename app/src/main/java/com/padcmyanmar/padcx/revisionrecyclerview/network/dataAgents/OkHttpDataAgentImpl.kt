//package com.padcmyanmar.padcx.revisionrecyclerview.network.dataAgents
//
//import android.os.AsyncTask
//import com.google.gson.Gson
//import com.padcmyanmar.padcx.revisionrecyclerview.data.vos.NewsVO
//import com.padcmyanmar.padcx.revisionrecyclerview.network.responses.GetAllNewsResponse
//import com.padcmyanmar.padcx.revisionrecyclerview.utils.BASE_URL
//import com.padcmyanmar.padcx.revisionrecyclerview.utils.EM_INTERNET_CONNECTION
//import com.padcmyanmar.padcx.revisionrecyclerview.utils.GET_NEWS
//import com.padcmyanmar.padcx.revisionrecyclerview.utils.PARAM_ACCESS_TOKEN
//import okhttp3.FormBody
//import okhttp3.OkHttpClient
//import okhttp3.Request
//import java.util.concurrent.TimeUnit
//
//
//
//object OkHttpDataAgentImpl : NewsDataAgent {
//
//    private val mClient: OkHttpClient = OkHttpClient.Builder()
//        .connectTimeout(15, TimeUnit.SECONDS)
//        .readTimeout(15,TimeUnit.SECONDS)
//        .writeTimeout(15,TimeUnit.SECONDS)
//        .build()
//
//    override fun getAllNews(accessToken : String,
//                            onSuccess: (ArrayList<NewsVO>) -> Unit,
//                            onFailure: (String) -> Unit
//                            ) {
//        GetNewsTask(mAccessToken = accessToken,
//            onSuccess = onSuccess,
//            onFailure = onFailure,
//            mOkHttpClient = mClient
//            )
//    }
//
//    class GetNewsTask(val mAccessToken: String,
//                      val onSuccess: (ArrayList<NewsVO>) -> Unit,
//                      val onFailure: (String) -> Unit,
//                      val mOkHttpClient: OkHttpClient
//                      ) : AsyncTask<Void,Void,GetAllNewsResponse>(){
//        override fun doInBackground(vararg params: Void?): GetAllNewsResponse? {
//            val formBody= FormBody.Builder()
//                .add(PARAM_ACCESS_TOKEN,mAccessToken)
//                .build()
//
//            val request= Request.Builder()
//                .url(BASE_URL+ GET_NEWS)
//                .post(formBody)
//                .build()
//
//            try {
//                val response=mOkHttpClient
//                    .newCall(request)
//                    .execute()
//
//                if(response.isSuccessful){
//                    response.body?.let {
//                        val responseString=it.string()
//                        return Gson().fromJson<GetAllNewsResponse>(
//                            responseString,
//                            GetAllNewsResponse::class.java
//                        )
//                    }
//                }
//            }catch (e:Exception){
//
//            }
//            return null
//        }
//
//        override fun onPostExecute(result: GetAllNewsResponse?) {
//            super.onPostExecute(result)
//            if(result != null){
//                if(result.isResponseOk()){
//            result.data.let {
//                onSuccess(it)
//            }
//        }else{
//            onFailure(result.message)
//        }
//    }else{
//        onFailure(EM_INTERNET_CONNECTION)
//    }
//}
//        }
//
//
//}