package com.example.appthitracnghiem.model

import android.text.TextUtils
import android.util.Patterns

data class Email(val email : String,val password : String) {
    fun isEmail() : Boolean{
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    fun isPassword() : Boolean{
        return !TextUtils.isEmpty(password) && password.length >= 6
    }
}