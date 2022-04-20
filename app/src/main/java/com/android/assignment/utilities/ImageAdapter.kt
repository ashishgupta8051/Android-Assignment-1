package com.android.assignment.utilities

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.android.assignment.R

@BindingAdapter("setImageUri")
fun setImageUri(imageView: ImageView, imageUri: String?) {
    if (imageUri == null) {
        imageView.setImageResource(R.drawable.ic_launcher_background)
    } else {
        Glide.with(imageView.context).load(imageUri).into(imageView)
    }
}