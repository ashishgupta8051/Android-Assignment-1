package com.android.assignment.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.assignment.R
import com.android.assignment.adapter.UserAdapter
import com.android.assignment.databinding.FragmentUserBinding
import com.android.assignment.repository.UserRepository
import com.android.assignment.viewmodel.UserViewModel
import com.android.assignment.viewmodelfactory.UserViewModelFactory


class UserFragment : Fragment() {
    private lateinit var binding:FragmentUserBinding
    private lateinit var userViewModel: UserViewModel
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var userAdapter: UserAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(LayoutInflater.from(requireContext()),R.layout.fragment_user,container,false)

        val newsRepository = UserRepository()
        val newsViewModelFactory = UserViewModelFactory(newsRepository)
        userViewModel = ViewModelProvider(this,newsViewModelFactory)[UserViewModel::class.java]
        userViewModel.getUsers(requireContext()).observe(viewLifecycleOwner){ response ->
            binding.progressBar.visibility = View.GONE
            binding.recyclerView.setHasFixedSize(true)
            linearLayoutManager = LinearLayoutManager(requireContext())
            binding.recyclerView.layoutManager = linearLayoutManager
            userAdapter = UserAdapter()
            userAdapter.getUsers(response)
            binding.recyclerView.adapter = userAdapter
        }

        return binding.root
    }

    override fun onResume() {
        super.onResume()

        binding.back.setOnClickListener {
            requireActivity().finishAffinity()
        }
    }

}