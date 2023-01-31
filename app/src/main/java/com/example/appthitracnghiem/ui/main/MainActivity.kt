package com.example.appthitracnghiem.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.example.appthitracnghiem.R
import com.example.appthitracnghiem.model.MySharedPreferences
import com.example.appthitracnghiem.ui.intro.IntroActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var KEY_FIRST_INSTALL : String ="KEY_FIRST_INSTALL"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var mySharedPreferences : MySharedPreferences = MySharedPreferences(this@MainActivity)

        var anim_logo : Animation = AnimationUtils.loadAnimation(this@MainActivity,R.anim.anim_logo)
        logo.startAnimation(anim_logo)

        var countDownTimer : CountDownTimer = object : CountDownTimer(3000,3000){
            override fun onTick(millisUntilFinished: Long) {

            }

            override fun onFinish() {
//                if(mySharedPreferences.getBooleanValue(KEY_FIRST_INSTALL)){
//                    var intent : Intent = Intent(this@MainActivity,LoginActivity::class.java)
//                    startActivity(intent)
//                    finish()
//                }else{
                    var intent : Intent = Intent(this@MainActivity,IntroActivity::class.java)
                    startActivity(intent)
                    finish()
//                    mySharedPreferences.putBooleanValue(KEY_FIRST_INSTALL,true)
//                }
            }

        }
        countDownTimer.start()
    }

    override fun onBackPressed() {

    }
}