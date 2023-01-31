package com.example.appthitracnghiem.ui.intro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.appthitracnghiem.R
import com.example.appthitracnghiem.adapter.ViewPagerAdapter
import kotlinx.android.synthetic.main.activity_intro.*

@Suppress("DEPRECATION")
class IntroActivity : AppCompatActivity() {
    private lateinit var viewPagerAdapter: ViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        viewPagerAdapter = ViewPagerAdapter(supportFragmentManager,
            FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT)

        viewPagerIntro.adapter = viewPagerAdapter
        indicatorIntro.setViewPager(viewPagerIntro)

        hideButton()

        clickNext()

        skip.setOnClickListener {
            var intent : Intent = Intent(this,IntroLoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    /** Next ViewPager*/
    private fun clickNext() {
        nextIntro.setOnClickListener {
            when (viewPagerIntro.currentItem) {
                2 -> {
                    var intent : Intent = Intent(this,IntroLoginActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                else -> {
                    viewPagerIntro.currentItem += 1
                }
            }
        }
    }

    private fun hideButton() {
        viewPagerIntro.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int,
            ) {

            }

            override fun onPageSelected(position: Int) {
//                if(viewPagerIntro.currentItem == 2){
//                    nextIntro.visibility = View.INVISIBLE
//                    indicatorIntro.visibility = View.INVISIBLE
//                    skip.visibility = View.INVISIBLE
//                }else{
//                    nextIntro.visibility = View.VISIBLE
//                    indicatorIntro.visibility = View.VISIBLE
//                    skip.visibility = View.VISIBLE
//                }
            }

            override fun onPageScrollStateChanged(state: Int) {

            }

        })
    }
}