package com.android.assignment.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.assignment.R
import com.android.assignment.databinding.ActivityMainBinding
import com.android.assignment.ui.fragment.UserFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_layout, UserFragment()).commit()

    }

    override fun onBackPressed() {
        finishAffinity()
    }
}