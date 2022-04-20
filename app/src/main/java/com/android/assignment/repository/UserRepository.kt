package com.android.assignment.repository

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.android.assignment.network.ApiClient
import com.android.assignment.response.UserResponse
import com.android.assignment.utils.MessageUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository {
    val userDetails: MutableLiveData<ArrayList<UserResponse>> = MutableLiveData()

    fun getUser(context:Context): MutableLiveData<ArrayList<UserResponse>> {
        val call: Call<ArrayList<UserResponse>> = ApiClient.getApiClient().getApi().getUser()
        call.enqueue(object: Callback<ArrayList<UserResponse>> {
            override fun onResponse(call: Call<ArrayList<UserResponse>>, response: Response<ArrayList<UserResponse>>) {
                if (response.isSuccessful){
                    userDetails.postValue(response.body())
                }else{
                    MessageUtils.shortToast(context,"Something Gone Wrong, Please Try Again")
                }
            }

            override fun onFailure(call: Call<ArrayList<UserResponse>>, t: Throwable) {
                MessageUtils.shortToast(context,t.message.toString())
            }
        })
        return userDetails
    }
}