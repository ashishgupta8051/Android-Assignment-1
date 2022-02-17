package com.volunteer.newsapp.utils

import android.content.Context
import android.widget.Toast

object MessageUtils {

    fun shortToast(context:Context,message:String){
        Toast.makeText(context,message,Toast.LENGTH_SHORT).show()
    }
}