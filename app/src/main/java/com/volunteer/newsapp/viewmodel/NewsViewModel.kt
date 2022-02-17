package com.volunteer.newsapp.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.volunteer.newsapp.repository.NewsRepository
import com.volunteer.newsapp.response.NewsResponse


class NewsViewModel(private val newsRepository: NewsRepository): ViewModel() {

    fun getNewsDetails(apiKey:String,query:String,context: Context):LiveData<NewsResponse>{
        return newsRepository.getNewsDetails(apiKey,query,context)
    }

}