package com.example.appthitracnghiem.ui.base

import android.util.Log
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment(), IOnFragmentBackListener{
    override fun onFragmentBack(): Boolean {
//        Log.e("Base", "BaseFragment - ${javaClass.simpleName} onFragmentBack")
        return false
    }

}