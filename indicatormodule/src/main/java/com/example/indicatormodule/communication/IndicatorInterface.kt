package com.example.indicatormodule.communication

import androidx.viewpager.widget.ViewPager
import com.example.indicatormodule.excaption.PageLessException

interface IndicatorInterface {
    /**
     * @param viewPager: The viewpager
     * @throws PageLessException: exception if viewpager.child count <2
     * */
    @Throws(PageLessException::class)
    fun setViewPager(viewPager: ViewPager)

    /**
     * @param duration: time between selected to unselected
     * */
    fun setAnimationDuration(duration: Long)

    /**
     * @param radius: radius in pixel
     * */
    fun setRadiusSelected(radius: Int)

    /**
     * @param radius: radius in pixel
     * */
    fun setRadiusUnSelected(radius: Int)

    /**
     * @param color: color when selected
     * */
    fun setColorSelected(color: Int)

    /**
     * @param color: color when unSelected
     * */
    fun setColorUnSelected(color: Int)
}