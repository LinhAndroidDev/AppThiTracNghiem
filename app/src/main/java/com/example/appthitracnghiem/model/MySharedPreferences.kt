package com.example.appthitracnghiem.model

import android.content.Context
import android.content.SharedPreferences

class MySharedPreferences(val context: Context) {
    var MY_SHARED_PREFERENCES : String ="MY_SHARED_PREFERENCES"

    fun putBooleanValue(key : String,value : Boolean){
        var sharedPreferences : SharedPreferences = context.getSharedPreferences("MY_SHARED_PREFERENCES",0)
        var editor : SharedPreferences.Editor = sharedPreferences.edit()
        editor.putBoolean(key, value)
        editor.apply()
    }

    fun getBooleanValue(key : String) : Boolean{
        var sharedPreferences : SharedPreferences = context.getSharedPreferences("MY_SHARED_PREFERENCES",0)
        return sharedPreferences.getBoolean(key,false)
    }
}