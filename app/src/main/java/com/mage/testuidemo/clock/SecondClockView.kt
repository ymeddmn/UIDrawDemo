package com.mage.testuidemo.clock

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View

/**
 * author  :mayong
 * function:
 * date    :2020/12/8
 **/
class SecondClockView : BaskClockView {
    var paint = Paint()

    constructor(context: Context, attributeSet: AttributeSet?) : super(context, attributeSet) {
        paint.color = Color.YELLOW
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val parentWidth = MeasureSpec.getSize(widthMeasureSpec)
        val parentHeight = MeasureSpec.getSize(heightMeasureSpec)
        setMeasuredDimension(parentWidth, parentWidth)
        radius = measuredWidth / 2f
        perSize = radius / 100
        paint.isAntiAlias = false
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.apply {
            translate(width / 2f, height / 2f)
            rotationDraw(canvas)
            Log.e(TAG, "onDraw: 绘制second")
            rotationDraw(canvas)
            paint.color = Color.GREEN
            drawCircle(0f, 0f, radius, paint)
            paint.color = Color.WHITE
            paint.textSize = perSize * 8
            var bound = Rect()
            for (i in 1..60) {
                rotate(6f, 0f, 0f)
                if (i % 5 == 0) {
                    paint.getTextBounds(i.toString(), 0, i.toString().length, bound)
                    drawText(i.toString(), 0f - bound.width() / 2, -radius + perSize * 13, paint)
                } else {
                    drawCircle(0f, -radius + perSize * 10, perSize * 2, paint)
                }

            }
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        super.onTouchEvent(event)

        return true
    }
}