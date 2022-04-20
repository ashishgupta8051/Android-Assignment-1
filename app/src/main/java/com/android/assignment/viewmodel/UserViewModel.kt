package com.android.assignment.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.android.assignment.repository.UserRepository
import com.android.assignment.response.UserResponse


class UserViewModel(private val userRepository: UserRepository): ViewModel() {

    fun getUsers(context: Context):LiveData<ArrayList<UserResponse>>{
        return userRepository.getUser(context)
    }

}