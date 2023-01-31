package com.example.appthitracnghiem.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.appthitracnghiem.R
import com.example.appthitracnghiem.ui.base.BaseFragment

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        replaceFragmentRegister(Fragment_Register())

        overridePendingTransition(R.anim.anim_translate_enter_right, R.anim.anim_translate_exit_left)
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

    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.anim_translate_enter_left, R.anim.anim_translate_exit_right)
    }
}