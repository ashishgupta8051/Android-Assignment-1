package com.volunteer.newsapp.repository

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.volunteer.newsapp.network.ApiClient
import com.volunteer.newsapp.response.NewsResponse
import com.volunteer.newsapp.utils.MessageUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsRepository {
    val newsDetails: MutableLiveData<NewsResponse> = MutableLiveData()

    fun getNewsDetails(apiKey: String,query:String,context:Context): MutableLiveData<NewsResponse> {
        val call: Call<NewsResponse> = ApiClient.getApiClient().getApi().getNews(apiKey, query)
        call.enqueue(object: Callback<NewsResponse> {
            override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
                if (response.isSuccessful){
                    newsDetails.postValue(response.body())
                }else{
                    MessageUtils.shortToast(context,"Something Gone Wrong, Please Try Again")
                }
            }

            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                MessageUtils.shortToast(context,t.message.toString())
            }
        })
        return newsDetails
    }
}