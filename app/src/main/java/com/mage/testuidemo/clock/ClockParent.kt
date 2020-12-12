package com.mage.testuidemo.clock

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.widget.FrameLayout

/**
 * author  :mayong
 * function:
 * date    :2020/12/8
 **/
class ClockParent : FrameLayout {
    private lateinit var secondClockView: SecondClockView
    private lateinit var minuteClockView: MinuteClockView
    var TAG = "clockParent"
    private lateinit var hourClockView: HourClockView

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attributes: AttributeSet?) : super(context, attributes) {
        setWillNotDraw(false)
        secondClockView = SecondClockView(context, attributes)
        addView(secondClockView)
        minuteClockView = MinuteClockView(context, attributes)
        addView(minuteClockView)
        hourClockView = HourClockView(context, attributes)
        addView(hourClockView)
        Log.e(TAG, "clockparent: ")
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val measureWidth = MeasureSpec.getSize(widthMeasureSpec)
        setMeasuredDimension(measuredWidth,measuredHeight)
    }
    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
        val secondLeft = (width - secondClockView.width) / 2
        val secondTop = (height - secondClockView.height) / 2
        secondClockView.layout(secondLeft, secondTop, width - secondLeft, height - secondTop)

        val minuteLeft = (width - minuteClockView.width) / 2
        val minuteTop = (height - minuteClockView.height) / 2
        minuteClockView.layout(minuteLeft, minuteTop, width - minuteLeft, height - minuteTop)

        val hourLeft = (width - hourClockView.width) / 2
        val hourTop = (height - hourClockView.height) / 2
        hourClockView.layout(hourLeft, hourTop, width - hourLeft, height - hourTop)

        Log.e(TAG, "onLayout: top second: $minuteTop    : $hourTop   : $secondTop" )


    }
}