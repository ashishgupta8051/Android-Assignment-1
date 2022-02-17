package com.volunteer.newsapp.viewmodelfactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.volunteer.newsapp.repository.NewsRepository
import com.volunteer.newsapp.viewmodel.NewsViewModel

@Suppress("UNCHECKED_CAST")
class NewsViewModelFactory(private val newsRepository: NewsRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NewsViewModel(newsRepository) as T
    }


}