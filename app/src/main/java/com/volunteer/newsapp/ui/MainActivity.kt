package com.volunteer.newsapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.volunteer.newsapp.adapter.NewsAdapter
import com.volunteer.newsapp.databinding.ActivityMainBinding
import com.volunteer.newsapp.repository.NewsRepository
import com.volunteer.newsapp.utils.Credentials
import com.volunteer.newsapp.viewmodel.NewsViewModel
import com.volunteer.newsapp.viewmodelfactory.NewsViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var newsViewModel: NewsViewModel
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var newsAdapter: NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        val newsRepository = NewsRepository()
        val newsViewModelFactory = NewsViewModelFactory(newsRepository)
        newsViewModel = ViewModelProvider(this,newsViewModelFactory)[NewsViewModel::class.java]
        newsViewModel.getNewsDetails(Credentials.API_KEY,Credentials.QUARRY,applicationContext).observe(this){
            response ->
            binding.progressBar.visibility = View.GONE
            binding.recyclerView.setHasFixedSize(true)
            linearLayoutManager = LinearLayoutManager(this)
            binding.recyclerView.layoutManager = linearLayoutManager
            newsAdapter = NewsAdapter()
            newsAdapter.getNews(response.newsList)
            binding.recyclerView.adapter = newsAdapter
        }


        binding.search.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                newsAdapter.filter.filter(p0)
            }

            override fun afterTextChanged(p0: Editable?) {

            }
        })
    }
}