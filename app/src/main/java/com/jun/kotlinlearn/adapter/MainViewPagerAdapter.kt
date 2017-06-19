package com.jun.kotlinlearn.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 * Desc
 * Created by Jun on 2017/6/16.
 */
class MainViewPagerAdapter(var fm: FragmentManager, var list: List<Fragment>): FragmentPagerAdapter(fm) {


    override fun getItem(position: Int): Fragment = list[position]

    override fun getCount(): Int = list.size
}