package com.android.assignment.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.android.assignment.R
import com.android.assignment.databinding.UserListBinding
import com.android.assignment.response.UserResponse
import kotlin.collections.ArrayList

class UserAdapter : RecyclerView.Adapter<UserAdapter.NewsHolder>() {
    private var userList: ArrayList<UserResponse> = ArrayList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsHolder {
        val binding: UserListBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.user_list, parent, false)
        return NewsHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsHolder, position: Int) {
        val newsDetails = userList[position]
        holder.onBind(newsDetails)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    inner class NewsHolder(binding: UserListBinding) : RecyclerView.ViewHolder(binding.root) {
        private val binding: UserListBinding? = DataBindingUtil.bind(itemView)

        fun onBind(user: UserResponse){
            binding!!.userRespone = user
            binding.subjects = user.userSubject.toString().replace("[","").replace("]","")
            binding.qualifications = user.userQualification.toString().replace("[","").replace("]","")
            binding.executePendingBindings()
        }

    }

    @SuppressLint("NotifyDataSetChanged")
    fun getUsers(list: List<UserResponse>) {
        userList = list as ArrayList<UserResponse>
        notifyDataSetChanged()
    }
}