package com.example.appthitracnghiem.ui.home.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.appthitracnghiem.R
import com.example.appthitracnghiem.model.CheckShowTutorial
import com.example.appthitracnghiem.ui.base.BaseActivity
import com.example.appthitracnghiem.ui.base.BaseFragment
import com.example.appthitracnghiem.ui.home.category.FragmentCategory
import com.example.appthitracnghiem.ui.home.createtest.FragmentCreateTest
import com.example.appthitracnghiem.ui.home.historytest.FragmentHistory
import com.example.appthitracnghiem.ui.home.profile.FragmentProfile
import kotlinx.android.synthetic.main.activity_home_page.*

class HomeActivity : BaseActivity() {
    var CHECK_SHOW_TUTORIAL : String = "CHECK_SHOW_TUTORIAL"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        val checkShowTutorial : CheckShowTutorial = CheckShowTutorial(this@HomeActivity)
        checkShowTutorial.putBooleanValue("CHECK_SHOW_TUTORIAL",true)

        resetTab()
        functionHome.isSelected = true
        replaceFragment(FragmentHome())

        bottom_wrap?.setOnTouchListener { _, _ ->  true }

        iconSearch.setOnClickListener{
            var fm = supportFragmentManager.findFragmentById(R.id.changeIdHome)
            if(fm !is FragmentCategory) {
                resetTab()
                replaceFragment(FragmentCategory())
            }
        }

        functionHome.setOnClickListener {
            var fm = supportFragmentManager.findFragmentById(R.id.changeIdHome)
            if(fm !is FragmentHome){
                resetTab()
                functionHome.isSelected = true
                replaceFragment(FragmentHome())
            }
        }

        functionCreate.setOnClickListener {
            var fm = supportFragmentManager.findFragmentById(R.id.changeIdHome)
            if(fm !is FragmentCreateTest){
                resetTab()
                functionCreate.isSelected = true
                replaceFragment(FragmentCreateTest())
            }
        }

        functionLeaderboard.setOnClickListener {
            var fm = supportFragmentManager.findFragmentById(R.id.changeIdHome)
            if(fm !is FragmentHistory){
                resetTab()
                functionLeaderboard.isSelected = true
                replaceFragment(FragmentHistory())
            }
        }

        functionProfile.setOnClickListener {
            var fm = supportFragmentManager.findFragmentById(R.id.changeIdHome)
            if(fm !is FragmentProfile){
                resetTab()
                functionProfile.isSelected = true
                replaceFragment(FragmentProfile())
            }
        }

    }

    /** Select Icon */
    private fun setSelectIcon(){
        var fm = supportFragmentManager.findFragmentById(R.id.changeIdHome)

        if(fm is FragmentHome){
            resetTab()
            functionHome.isSelected = true
        }
        if(fm is FragmentCategory){
            resetTab()
        }
        if(fm is FragmentCreateTest){
            resetTab()
            functionCreate.isSelected = true
        }
        if(fm is FragmentHistory){
            resetTab()
            functionLeaderboard.isSelected = true
        }
        if(fm is FragmentProfile){
            resetTab()
            functionProfile.isSelected = true
        }
    }

    /** Reset Select Icon */
    private fun resetTab() {
        functionHome.isSelected = false
        functionCreate.isSelected = false
        functionLeaderboard.isSelected = false
        functionProfile.isSelected = false
    }

    /** Replace Fragment */
    fun replaceFragment(fragment : Fragment){
        var fm = supportFragmentManager.beginTransaction()
        fm.setCustomAnimations(R.anim.animation_enter_right,R.anim.animation_exit_left,
            R.anim.animation_enter_left,R.anim.animation_exit_right)
        fm.replace(R.id.changeIdHome,fragment).addToBackStack(null).commit()
    }

    /** Click Back */
    override fun onBackPressed() {
        var fm = supportFragmentManager.findFragmentById(R.id.changeIdHome)

        if (fm != null && fm is BaseFragment) {
            if (fm.onFragmentBack()) {
                finish()
            } else {
                super.onBackPressed()
                setSelectIcon()
            }
        } else {
            super.onBackPressed()
            setSelectIcon()
        }
    }
}