package com.mage.testuidemo.clock

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View

/**
 * author  :mayong
 * function:
 * date    :2020/12/8
 **/

open class BaskClockView : View {
    private var isMovingn: Boolean = false
    private var downDegree: Int = 0//手指按下未知的角度
    private var curDegree: Int = 0//当前move的角度
    private var downX: Float = 0f
    private var downY: Float = 0f
    val TAG = "clockview"
    var perSize = 0f//将半径分为100份
    var radius = 0f

    constructor(context: Context) : this(context, null) {

    }

    constructor(context: Context, attributes: AttributeSet?) : super(context, attributes) {

    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        Log.e(TAG, "onDraw: baskClockview")
    }

    fun rotationDraw(canvas: Canvas?) {
        if (isMovingn) {
            canvas?.apply {
//            translate(radius,radius)
                rotate((curDegree - downDegree).toFloat(), 0f, 0f)
            }
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        event?.apply {
            when (action) {

                MotionEvent.ACTION_DOWN -> {
                    isMovingn = true
                    downX = x
                    downY = y
                    downDegree = computeCurrentAngle(downX, downY)
                }
                MotionEvent.ACTION_MOVE -> {
                    var moveX = x
                    var moveY = y
                    curDegree = computeCurrentAngle(moveX, moveY)
                    invalidate()
                }
                MotionEvent.ACTION_UP -> {
                    downDegree = 0
                    curDegree = 0
                    isMovingn = false
                }
                MotionEvent.ACTION_CANCEL -> {
                    isMovingn = false
                }
            }
        }
        return super.onTouchEvent(event)
    }

    /**
     * 计算某点的角度
     *
     * @param x
     * @param y
     * @return
     */
    private fun computeCurrentAngle(x: Float, y: Float): Int {
        val distance = Math
            .sqrt(
                ((x - radius) * (x - radius) + (y - radius)
                        * (y - radius)).toDouble()
            ).toFloat()
        var degree =
            (Math.acos((x - radius) / distance.toDouble()) * 180 / Math.PI).toInt()
        if (y < radius) {
            degree = -degree
        }
        return degree
    }
}