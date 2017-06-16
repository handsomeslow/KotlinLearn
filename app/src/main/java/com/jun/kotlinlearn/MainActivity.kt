package com.jun.kotlinlearn

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.MenuItem
import com.ashokvarma.bottomnavigation.BottomNavigationBar
import com.ashokvarma.bottomnavigation.BottomNavigationItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() ,BottomNavigationBar.OnTabSelectedListener,ViewPager.OnPageChangeListener{

    private val fragments: ArrayList<Fragment> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initMainView()
    }

    private fun initMainView() {
        fragments.add(NewsListFragment.newInstace())
        fragments.add(AboutFragment.newInstace())

        val mainAdapter = MainViewPagerAdapter(this.supportFragmentManager,fragments)
        mainViewPager.adapter = mainAdapter
        mainViewPager.addOnPageChangeListener(this)
        bottomBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_RIPPLE)
        bottomBar.setMode(BottomNavigationBar.MODE_SHIFTING)
        bottomBar.addItem(BottomNavigationItem(R.drawable.contacts,"新闻"))
                .addItem(BottomNavigationItem(R.drawable.settings,"设置"))
                .setActiveColor(R.color.colorPrimary)
                .setFirstSelectedPosition(0)
                .initialise()

        bottomBar.setTabSelectedListener(this)
    }

    override fun onTabSelected(position: Int) {
        mainViewPager.currentItem = position
    }

    override fun onTabReselected(position: Int) {
    }

    override fun onTabUnselected(position: Int) {
    }


    override fun onPageScrollStateChanged(state: Int) {
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
    }

    override fun onPageSelected(position: Int) {
        bottomBar.selectTab(position)
    }
}
