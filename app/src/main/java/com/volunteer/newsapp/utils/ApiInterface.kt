package com.volunteer.newsapp.utils

import com.volunteer.newsapp.response.NewsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ApiInterface {

    @GET("everything")
    fun getNews(
        @Header("Authorization") apiKey : String,
        @Query("q") query:String
    ): Call<NewsResponse>

}