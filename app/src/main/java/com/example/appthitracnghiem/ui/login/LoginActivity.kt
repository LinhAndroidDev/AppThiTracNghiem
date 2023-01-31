package com.example.appthitracnghiem.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.appthitracnghiem.R
import com.example.appthitracnghiem.ui.base.BaseFragment

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        replaceFragmentLogin(Fragment_Login())

        overridePendingTransition(R.anim.anim_translate_enter_right, R.anim.anim_translate_exit_left)
    }

    companion object fun replaceFragmentLogin(fragment : Fragment){
        var fm : FragmentTransaction = supportFragmentManager.beginTransaction()
        fm.addToBackStack("Fragment_Login")
        fm.replace(R.id.loginContainerID,fragment).commit()
    }

    override fun onBackPressed() {

        val fragment = supportFragmentManager.findFragmentById(R.id.loginContainerID)
        if(fragment != null && fragment is BaseFragment){
            if(fragment.onFragmentBack()){
                finish()
            } else {
                super.onBackPressed()
            }
        } else {
            super.onBackPressed()
        }
    }

    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.anim_translate_enter_left, R.anim.anim_translate_exit_right)
    }
}