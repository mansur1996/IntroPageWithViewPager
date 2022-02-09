package com.example.intropage.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.viewpager.widget.ViewPager
import com.example.intropage.R
import com.example.intropage.adapter.ViewPagerAdapter
import com.example.intropage.fragment.FirstFragment
import com.example.intropage.fragment.SecondFragment
import com.example.intropage.fragment.ThirdFragment
import me.relex.circleindicator.CircleIndicator

class MainActivity : AppCompatActivity(), ViewPager.OnPageChangeListener {

    private lateinit var skipTv : TextView
    private lateinit var getStartedBtn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews(){


        setUpViewPager()
    }
    private fun setUpViewPager(){
        var viewPager = findViewById<ViewPager>(R.id.viewpager)
        val circleIndicator = findViewById<CircleIndicator>(R.id.ci_circle_indicator)
        skipTv = findViewById<TextView>(R.id.tv_skip)
        getStartedBtn = findViewById<Button>(R.id.btn_get_started)

        setViewPager(viewPager, circleIndicator)

        skipTv.setOnClickListener {
            viewPager.currentItem = 3
            skipTv.visibility = View.GONE
            getStartedBtn.visibility = View.VISIBLE
        }

    }
    private fun setViewPager(vp : ViewPager, circleIndicator: CircleIndicator){
        vp.setOnPageChangeListener(this)
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.add(FirstFragment())
        adapter.add(SecondFragment())
        adapter.add(ThirdFragment())
        vp.adapter = adapter

        circleIndicator.setViewPager(vp)
        adapter.registerDataSetObserver(circleIndicator.dataSetObserver)
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
        Log.d("@@@", "onPageScrolled")

    }

    override fun onPageSelected(position: Int) {
        Log.d("@@@", "onPageSelected")
        if(position == 2){
            skipTv.visibility = View.GONE
            getStartedBtn.visibility = View.VISIBLE

        }else{
            getStartedBtn.visibility = View.GONE
            skipTv.visibility = View.VISIBLE
        }
    }

    override fun onPageScrollStateChanged(state: Int) {
        Log.d("@@@", "onPageScrollStateChanged")
    }

}
