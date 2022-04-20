package com.android.assignment.utils

import com.android.assignment.response.UserResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("users")
    fun getUser(): Call<ArrayList<UserResponse>>

}