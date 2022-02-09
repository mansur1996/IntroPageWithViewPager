package com.example.intropage.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ViewPagerAdapter(val fm : FragmentManager) : FragmentPagerAdapter(fm){

    private val fragments : ArrayList<Fragment> = ArrayList()

    fun add(fragment : Fragment){
        fragments.add(fragment)
    }

    override fun getCount(): Int = fragments.size

    override fun getItem(position: Int): Fragment = fragments[position]

}