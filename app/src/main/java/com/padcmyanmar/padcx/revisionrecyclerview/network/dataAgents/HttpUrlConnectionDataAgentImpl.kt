//package com.padcmyanmar.padcx.revisionrecyclerview.network.dataAgents
//
//import android.os.AsyncTask
//import android.util.Log
//import com.google.gson.Gson
//import com.padcmyanmar.padcx.revisionrecyclerview.data.vos.NewsVO
//import com.padcmyanmar.padcx.revisionrecyclerview.network.responses.GetAllNewsResponse
//import com.padcmyanmar.padcx.revisionrecyclerview.utils.BASE_URL
//import com.padcmyanmar.padcx.revisionrecyclerview.utils.EM_INTERNET_CONNECTION
//import com.padcmyanmar.padcx.revisionrecyclerview.utils.GET_NEWS
//import java.io.*
//import java.net.HttpURLConnection
//import java.net.URL
//
//object HttpUrlConnectionDataAgentImpl: NewsDataAgent {
//    override fun getAllNews(onSuccess : (ArrayList<NewsVO>) -> Unit,
//                            onFailure : (String) -> Unit) {
//        GetNewsTask(onSuccess = onSuccess,
//            onFailure = onFailure)
//    }
//
//    class GetNewsTask(val onSuccess: (ArrayList<NewsVO>) -> Unit,
//                      val onFailure: (String) -> Unit) : AsyncTask<Void,Void,GetAllNewsResponse>(){
//        override fun doInBackground(vararg params: Void?): GetAllNewsResponse? {
//            val url: URL
//            var reader: BufferedReader? = null
//            val stringBuilder: StringBuilder
//
//            try {
//                //create the HttpURLConnection
//                url = URL(BASE_URL + GET_NEWS)//1.
//                val connection = url.openConnection() as HttpURLConnection//2.
//
//                //just want to do an Http POST here
//                connection.requestMethod = "POST"//3.
//
//                //give it 15 seconds to respong
//                connection.readTimeout = 15 * 1000//4. ms
//
//                connection.doInput = false
//                //5.
//                connection.doOutput = true
//
//                //put the request parameter into NameValuePair list.
//
//
//                //write the parameters from NameValuePair List into connection obj.
//                val outputStream = connection.outputStream
//                val writer = BufferedWriter(OutputStreamWriter(outputStream, "UTF-8"))
//                writer.write(getQuery())
//                writer.flush()
//                writer.close()
//                outputStream.close()
//
//                connection.connect()//7.
//
//                //read the output from the server
//                reader = BufferedReader(
//                    InputStreamReader(connection.inputStream)
//                )//8.
//                stringBuilder = StringBuilder()
//
//                for (Line: String in reader.readLines()) {
//                    stringBuilder.append(Line + "\n")
//                }
//
//                val responseString = stringBuilder.toString()//9.
//
//                return Gson()
//                    .fromJson<GetAllNewsResponse>(responseString, GetAllNewsResponse::class.java)
//
//            } catch (e: Exception) {
//                e.printStackTrace()
//                Log.e("NewsError", e.message ?: "")
//
//
//            } finally {
//                //close the reader; this can throw an exception too,so
//                //wrap it in another try/catch block.
//                if (reader != null) {
//                    try {
//                        reader.close()
//                    } catch (ioe: IOException) {
//                        ioe.printStackTrace()
//                    }
//                }
//
//            }
//            return null
//        }
//
//        @Throws(UnsupportedEncodingException::class)
//        private fun getQuery():String{
//            val result=StringBuilder()
//            return result.toString()
//        }
//
//        override fun onPostExecute(result: GetAllNewsResponse?) {
//            super.onPostExecute(result)
//            if(result != null){
//                if(result.isResponseOk()){
//                    result.data.let {
//                        onSuccess(it)
//                    }
//                }else{
//                    onFailure(result.message)
//                }
//            }else{
//                    onFailure(EM_INTERNET_CONNECTION)
//            }
//        }
//    }
//}