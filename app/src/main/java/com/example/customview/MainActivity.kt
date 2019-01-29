package com.example.customview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val listFramgne = ArrayList<FragmentState>()
//        for (i in 0 until 3) {
//            listFramgne.add(FragmentState().setPosition(i))
//        }
//        var pagerAdapter = AdapterViewPager(supportFragmentManager).apply {
//            addFragment(listFramgne)
//        }
//
//        mViewPager.adapter = pagerAdapter
//        mViewPager.currentItem = 0
//        pagerAdapter.notifyDataSetChanged()
//        mIndicator.setViewPager(mViewPager)
//        mIndicator.setColorSelected(ContextCompat.getColor(this,android.R.color.holo_orange_dark))
    }
}
