package com.android.assignment.viewmodelfactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.assignment.repository.UserRepository
import com.android.assignment.viewmodel.UserViewModel

@Suppress("UNCHECKED_CAST")
class UserViewModelFactory(private val userRepository: UserRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UserViewModel(userRepository) as T
    }


}