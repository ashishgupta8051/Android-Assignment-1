package com.volunteer.newsapp.model

import com.google.gson.annotations.SerializedName

data class NewsDetails(
    @SerializedName("source")
    val source: SourceNews,
    @SerializedName("author")
    val author: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("urlToImage")
    val urlToImage: String,
    @SerializedName("publishedAt")
    val publishAt: String,
    @SerializedName("content")
    val content: String,
)
