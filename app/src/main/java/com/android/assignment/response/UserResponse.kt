package com.android.assignment.response

import com.google.gson.annotations.SerializedName


data class UserResponse(
    @SerializedName("id")
    val userId:Int,
    @SerializedName("name")
    val userName:String,
    @SerializedName("subjects")
    val userSubject:List<String>,
    @SerializedName("qualification")
    val userQualification:List<String>,
    @SerializedName("profileImage")
    val profileImage:String,


)
