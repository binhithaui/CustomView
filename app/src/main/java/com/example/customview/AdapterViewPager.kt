package com.example.customview

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter

class AdapterViewPager(fm: FragmentManager?) : FragmentPagerAdapter(fm) {
    private val mListFragment by lazy { ArrayList<FragmentState>() }
    override fun getItem(position: Int): Fragment = mListFragment[position]

    override fun getCount(): Int = mListFragment.size

    fun addFragment(fragment: ArrayList<FragmentState>) {
        this.mListFragment.addAll(fragment)
        notifyDataSetChanged()
    }
}