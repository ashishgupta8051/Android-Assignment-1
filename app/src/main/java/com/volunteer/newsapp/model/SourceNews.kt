package com.volunteer.newsapp.model

import com.google.gson.annotations.SerializedName

data class SourceNews (
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String
)
