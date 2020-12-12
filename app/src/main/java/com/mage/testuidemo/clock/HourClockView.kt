package com.mage.testuidemo.clock

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent

/**
 * author  :mayong
 * function:
 * date    :2020/12/8
 **/
class HourClockView : BaskClockView {
    constructor(context: Context) : this(context, null) {

    }

    constructor(context: Context, attributes: AttributeSet?) : super(context, attributes) {
        setWillNotDraw(false)
        Log.e(TAG, "构造Hour: ")
        paint.color = Color.RED
        paint.isAntiAlias=false
    }

    private val paint: Paint = Paint()

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val parentWidth = MeasureSpec.getSize(widthMeasureSpec)
        val parentHeight = MeasureSpec.getSize(heightMeasureSpec)
        setMeasuredDimension(parentWidth/3,parentHeight/3)
        perSize=measuredWidth/100f
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        Log.e(TAG, "onDraw: hour")
        Log.e(TAG, "onDraw: 宽高 $width  $height")
        canvas?.apply {
            translate(width / 2f, height / 2f)
            rotationDraw(canvas)
            paint.color=Color.RED
            drawCircle(0f,0f,width/2f,paint)
            paint.color=Color.WHITE
            paint.textSize=perSize*7f
            val bounds = Rect()
            for (i in 1..12) {
                rotate(360/12f)
                paint.getTextBounds(i.toString() + "", 0, (i.toString() + "").length, bounds)
                drawCircle(0f,width/2f-perSize*6+perSize,perSize*2,paint)
                drawText(i.toString(),0f-bounds.width()/2,-width/2+perSize*15,paint)
            }
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        super.onTouchEvent(event)
        return true
    }
}