package com.volunteer.newsapp.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.volunteer.newsapp.R
import com.volunteer.newsapp.databinding.NewsListBinding
import com.volunteer.newsapp.model.NewsDetails
import java.util.*
import kotlin.collections.ArrayList

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.NewsHolder>(), Filterable {
    private var newsList: ArrayList<NewsDetails> = ArrayList()
    private var newsListFilter: ArrayList<NewsDetails> = ArrayList()

    init {
        newsListFilter = newsList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsHolder {
        val binding: NewsListBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.news_list, parent, false)
        return NewsHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsHolder, position: Int) {
        val newsDetails = newsListFilter[position]
        holder.onBind(newsDetails)
    }

    override fun getItemCount(): Int {
        return newsListFilter.size
    }

    inner class NewsHolder(binding: NewsListBinding) : RecyclerView.ViewHolder(binding.root) {
        private val binding: NewsListBinding? = DataBindingUtil.bind(itemView)

        fun onBind(newsDetails: NewsDetails){
            binding!!.newsDetails = newsDetails
            binding.executePendingBindings()
        }

    }

    @SuppressLint("NotifyDataSetChanged")
    fun getNews(list: List<NewsDetails>) {
        newsList = list as ArrayList<NewsDetails>
        newsListFilter = newsList
        notifyDataSetChanged()
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charString = constraint?.toString() ?: ""
                newsListFilter = if (charString.isEmpty()) newsList else {
                    val filteredList = ArrayList<NewsDetails>()
                    newsList.filter {
                        (it.title.contains(constraint!!)) or (it.source.name.contains(constraint))
                    }.forEach { filteredList.add(it) }
                    filteredList
                }
                return FilterResults().apply { values = newsListFilter }
            }

            @Suppress("UNCHECKED_CAST")
            @SuppressLint("NotifyDataSetChanged")
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                newsListFilter = if (results?.values == null)
                    ArrayList()
                else
                    results.values as ArrayList<NewsDetails>
                notifyDataSetChanged()
            }
        }
    }
}