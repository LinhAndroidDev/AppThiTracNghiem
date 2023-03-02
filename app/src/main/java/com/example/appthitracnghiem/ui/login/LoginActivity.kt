package com.example.appthitracnghiem.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.appthitracnghiem.R
import com.example.appthitracnghiem.model.CheckShowTutorial
import com.example.appthitracnghiem.ui.base.BaseActivity
import com.example.appthitracnghiem.ui.base.BaseFragment

class LoginActivity : BaseActivity() {
    var CHECK_SHOW_TUTORIAL : String = "CHECK_SHOW_TUTORIAL"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val checkShowTutorial : CheckShowTutorial = CheckShowTutorial(this@LoginActivity)
        checkShowTutorial.putBooleanValue("CHECK_SHOW_TUTORIAL",false)

        replaceFragmentLogin(Fragment_Login())
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
}