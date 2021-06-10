package com.mahdikaseatashin.gpa.api

import com.mahdikaseatashin.gpa.models.NodeModel
import com.mahdikaseatashin.gpa.utils.Constants
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitService {

    @GET("repositories")
    suspend fun getAllNodes() : Response<List<NodeModel>>

//    companion object {
//        var retrofitService: RetrofitService? = null
//        fun getInstance() : RetrofitService {
//            if (retrofitService == null) {
//                val retrofit = Retrofit.Builder()
//                    .baseUrl(Constants.BASE_URL)
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .build()
//                retrofitService = retrofit.create(RetrofitService::class.java)
//            }
//            return retrofitService!!
//        }
//    }
}
