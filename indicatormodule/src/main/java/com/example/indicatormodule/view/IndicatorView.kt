package com.example.indicatormodule.view

import android.animation.AnimatorSet
import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.util.AttributeSet
import android.view.View
import androidx.viewpager.widget.ViewPager
import com.example.indicatormodule.R
import com.example.indicatormodule.communication.IndicatorInterface
import com.example.indicatormodule.excaption.PageLessException

class IndicatorView : View, IndicatorInterface, ViewPager.OnPageChangeListener {
    companion object {
        private const val DEFAULT_ANIMATE_DURATION = 200
        private const val DEFAULT_RADIUS_SELECTED = 20
        private const val DEFAULT_RADIUS_UNSELECTED = 15
        private const val DEFAULT_DISTANCE = 40
    }

    private lateinit var viewPager: ViewPager
    private lateinit var arrDot: ArrayList<Dot>
    private lateinit var animZoomIn: ValueAnimator
    private lateinit var animZoomOut: ValueAnimator

    private var colorSected: Int = 0
    private var colorUnselected: Int = 0
    private var currentPositionInt = 0
    private var beforePosition = 0
    private var animDuration: Long = DEFAULT_ANIMATE_DURATION.toLong()
    private var radiusSelected: Int = DEFAULT_RADIUS_SELECTED
    private var radiusUnSelected: Int = DEFAULT_RADIUS_UNSELECTED
    private var distance: Int = DEFAULT_DISTANCE

    constructor(context: Context?) : super(context)

    @SuppressLint("CustomViewStyleable")
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        val typeArray = context!!.obtainStyledAttributes(attrs, R.styleable.IndicatorCustomView)
        this.radiusSelected = typeArray.getDimensionPixelSize(
            R.styleable.IndicatorCustomView_indicator_radius_selected,
            DEFAULT_RADIUS_SELECTED
        )
        this.radiusUnSelected = typeArray.getDimensionPixelSize(
            R.styleable.IndicatorCustomView_indicator_radius_unselected,
            DEFAULT_RADIUS_UNSELECTED
        )
        this.colorSected = typeArray.getColor(
            R.styleable.IndicatorCustomView_indicator_color_selected,
            Color.parseColor("#ffffff")
        )
        this.colorUnselected = typeArray.getColor(
            R.styleable.IndicatorCustomView_indicator_color_unselected,
            Color.parseColor("#ffffff")
        )

        typeArray.recycle()
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)

        val yCenter: Float = (height / 2).toFloat()
        val d = distance + 2 * radiusSelected
        val firstCenter = (width / 2) - ((arrDot.size - 1) * d / 2)
        for (i in 0 until arrDot.size) {
            if (i == currentPositionInt) {
                arrDot[i].run {
                    setCenter(firstCenter.toFloat(), yCenter)
                    setCurrentRadius(radiusSelected)
                    setColor(colorSected)
                    setAlpha(255)
                }
            } else {
                arrDot[i].run {
                    setCenter((firstCenter + d * i).toFloat(), yCenter)
                    setColor(colorUnselected)
                    setCurrentRadius(radiusUnSelected)
                    setAlpha(radiusUnSelected * 255 / colorSected)
                }
            }
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val disiredHieght = 2 * radiusSelected
        val withMode = MeasureSpec.getMode(widthMeasureSpec)
        val heightMode = MeasureSpec.getMode(heightMeasureSpec)
        val withSize = MeasureSpec.getSize(widthMeasureSpec)
        val heightSize = MeasureSpec.getSize(heightMeasureSpec)

        val mWidth = if (withMode == MeasureSpec.EXACTLY || withMode == MeasureSpec.AT_MOST) {
            withSize
        } else {
            0
        }

        val mHeight = if (heightMode == MeasureSpec.EXACTLY || heightMode == MeasureSpec.AT_MOST) {
            heightSize
        } else {
            disiredHieght
        }

        setMeasuredDimension(mWidth, mHeight)
    }

    override fun onDraw(canvas: Canvas?) {
        arrDot.forEach {
            it.drawDot(canvas!!)
        }
    }

    @Throws(PageLessException::class)
    private fun initDot(numberOfDot: Int) {
        if (numberOfDot < 2) throw PageLessException()
        arrDot = ArrayList()
        for (i in 0 until numberOfDot) {
            arrDot.add(Dot())
        }
    }

    override fun setViewPager(viewPager: ViewPager) {
        this.viewPager = viewPager
        this.viewPager.addOnPageChangeListener(this)
        initDot(viewPager.adapter!!.count)
        onPageSelected(0)
    }

    override fun setAnimationDuration(duration: Long) {
        this.animDuration = duration
    }

    override fun setRadiusSelected(radius: Int) {
        this.radiusSelected = radius
    }

    override fun setRadiusUnSelected(radius: Int) {
        this.radiusUnSelected = radius
    }

    override fun setColorSelected(color: Int) {
        this.colorSected = color
    }

    override fun setColorUnSelected(color: Int) {
        this.colorUnselected = color
    }

    override fun onPageScrollStateChanged(state: Int) {}

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}

    override fun onPageSelected(position: Int) {
        beforePosition = currentPositionInt
        currentPositionInt = position

        if (beforePosition == currentPositionInt) {
            beforePosition = currentPositionInt + 1
        }

        arrDot[currentPositionInt].setColor(colorSected)
        arrDot[beforePosition].setColor(colorUnselected)

        val animatorSet = AnimatorSet()
        animatorSet.duration = animDuration

        animZoomIn = ValueAnimator.ofInt(radiusSelected, radiusSelected)
        animZoomIn.addUpdateListener(object : ValueAnimator.AnimatorUpdateListener {
            internal var positionPerform = currentPositionInt

            override fun onAnimationUpdate(valueAnimator: ValueAnimator) {
                val newRadius = valueAnimator.animatedValue as Int
                changeNewRadius(positionPerform, newRadius)
            }
        })

        animZoomOut = ValueAnimator.ofInt(radiusSelected, radiusUnSelected)
        animZoomOut.addUpdateListener(object : ValueAnimator.AnimatorUpdateListener {
            internal var positionPerform = beforePosition

            override fun onAnimationUpdate(valueAnimator: ValueAnimator) {
                val newRadius = valueAnimator.animatedValue as Int
                changeNewRadius(positionPerform, newRadius)
            }
        })

        animatorSet.play(animZoomIn).with(animZoomOut)
        animatorSet.start()
    }

    private fun changeNewRadius(position: Int, newRadius: Int) {
        if (arrDot[position].getCurrentRadius() != newRadius) {
            arrDot[position].setCurrentRadius(newRadius)
            arrDot[position].setAlpha(newRadius * 255 / radiusUnSelected)
            invalidate()
        }
    }

}