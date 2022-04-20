package com.volunteer.newsapp.response

import com.google.gson.annotations.SerializedName
import com.volunteer.newsapp.model.NewsDetails


data class NewsResponse(
    @SerializedName("status")
    val status:String,
    @SerializedName("totalResults")
    val totalResult:Long,
    @SerializedName("articles")
    val newsList:ArrayList<NewsDetails>,
    @SerializedName("code")
    val code:String,
    @SerializedName("message")
    val message:String
)
