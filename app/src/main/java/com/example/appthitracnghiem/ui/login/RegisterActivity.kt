package com.example.appthitracnghiem.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.appthitracnghiem.R
import com.example.appthitracnghiem.ui.base.BaseActivity
import com.example.appthitracnghiem.ui.base.BaseFragment

class RegisterActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        replaceFragmentRegister(Fragment_Register())
    }

    fun replaceFragmentRegister(fragment : Fragment){
        var fm : FragmentTransaction = supportFragmentManager.beginTransaction()
        fm.addToBackStack("Fragment_Register")
        fm.replace(R.id.registerContainerID,fragment).commit()
    }

    override fun onBackPressed() {
        var fragment = supportFragmentManager.findFragmentById(R.id.registerContainerID)

        if(fragment != null && fragment is BaseFragment){
            if(fragment.onFragmentBack()){
                finish()
            }else{
                super.onBackPressed()
            }
        }else{
            super.onBackPressed()
        }
    }
}