package com.mage.testuidemo.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

/**
 * author  :mayong
 * function:绘制阴影
 * date    :2020/12/12
 **/
class ShadowView : View {
    var mShadow: Float=0f
        set(value) {
            field=value
            invalidate()
        }
    var mshadowX: Float=0f
        set(value) {
            field=value
            invalidate()
        }
    var mshadowY: Float=0f
        set(value) {
            field=value
            invalidate()
        }

    var mPaint = Paint()
    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet) {
        mPaint.color= Color.WHITE
        mPaint.strokeWidth=1f
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.apply {
            translate(width/2f,300f)
            mPaint.setShadowLayer(mShadow/3+10, mshadowX/3, mshadowY/3, Color.GRAY)
            drawCircle(0f,300f,280f,mPaint)

        }
    }
}