package com.volunteer.newsapp.network
import com.volunteer.newsapp.utils.ApiInterface
import com.volunteer.newsapp.utils.Credentials
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    private var apiClient: ApiClient? = null
    private var retrofit: Retrofit? = null

    init {
        retrofit = Retrofit.Builder()
            .baseUrl(Credentials.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Synchronized
    fun getApiClient() : ApiClient {
        if (apiClient == null) {
            apiClient = ApiClient
        }
        return apiClient as ApiClient
    }

    fun getApi(): ApiInterface {
        return retrofit!!.create(ApiInterface::class.java)
    }
}