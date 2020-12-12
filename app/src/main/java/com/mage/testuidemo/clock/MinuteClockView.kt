package com.mage.testuidemo.clock

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.MotionEvent
import java.util.jar.Attributes

/**
 * author  :mayong
 * function:
 * date    :2020/12/8
 **/

class MinuteClockView : BaskClockView {
    private val paint: Paint = Paint()


    constructor(context: Context, attributes: AttributeSet?) : super(context, attributes) {
        paint.color = Color.BLUE
        paint.isAntiAlias=false
    }


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val parWidth = MeasureSpec.getSize(widthMeasureSpec)
        var parHeight = MeasureSpec.getSize(heightMeasureSpec)
        setMeasuredDimension(parWidth * 2 / 3, parHeight * 2 / 3)
        radius = parWidth / 3f
        perSize = radius / 100
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.apply {
            translate(width/2f, height/2f)
            rotationDraw(canvas)
            paint.color = Color.BLUE
            drawCircle(0f, 0f, radius, paint)
            paint.color = Color.WHITE
            paint.textSize = perSize * 10
            var bound = Rect()
            for (i in 1..60) {
                rotate(6f,0f,0f)
                if (i % 5 == 0) {
                    paint.getTextBounds(i.toString(), 0, i.toString().length, bound)
                    drawText(i.toString(), 0f - bound.width() / 2, -(radius - 13 * perSize), paint)
                } else {
                    drawCircle(0f, (radius - 10 * perSize), perSize, paint)
                }
            }
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        super.onTouchEvent(event)
        when (event?.action) {
            MotionEvent.ACTION_DOWN -> {

            }
            MotionEvent.ACTION_MOVE -> {

            }
            MotionEvent.ACTION_UP -> {

            }
        }

        return true
    }
}