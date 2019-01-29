package com.example.indicatormodule.view

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.PointF

/**
 * Shape dot
 * */
class Dot {
    private var paint: Paint? = null
    private var center: PointF? = null
    private var currentRadius: Int = -1

    init {
        paint = Paint().apply {
            isAntiAlias = true
        }
        center = PointF()
    }

    fun setColor(color: Int) {
        paint!!.color = color
    }

    fun setAlpha(alpha: Int) {
        paint!!.alpha = alpha
    }

    fun setCenter(x: Float, y: Float) {
        center!!.set(x, y)
    }

    fun setCurrentRadius(radius: Int) {
        this.currentRadius = radius
    }

    fun getCurrentRadius(): Int = currentRadius

    fun drawDot(canvas: Canvas) {
        canvas.drawCircle(center!!.x, center!!.y, currentRadius.toFloat(), paint!!)
    }
}