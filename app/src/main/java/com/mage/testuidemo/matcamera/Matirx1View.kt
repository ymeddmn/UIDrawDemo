package com.mage.testuidemo.matcamera

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

/**
 * author  :mayong
 * function:
 * date    :2020/12/11
 **/
class Matirx1View : View {
    private var paperHeight: Float = 0f
    private var paperWidth = 0f
    private val mPaint: Paint = Paint()
    var mCamera = Camera()
    var mMatrix = Matrix()
    var mRotateX = 0f
        set(value) {
            field = value
            invalidate()
        }

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet) {
        mPaint.color = Color.RED
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        paperWidth = measuredWidth * 2 / 3f
        paperHeight = measuredHeight * 2 / 3f
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.apply {
            translate(width / 2f, height / 2f)
            mPaint.color = Color.GREEN
            drawRoundRect(RectF(-paperWidth/2, -paperHeight/2, paperWidth/2, 0f), 20f, 20f, mPaint)
            mPaint.color = Color.BLUE
            drawRoundRect(RectF(-paperWidth/2, 0f, paperWidth/2, paperHeight/2), 20f, 20f, mPaint)
        }
        mCamera.save()
        mCamera.translate(0f, 0f, 0f)
        mCamera.rotateX(mRotateX)
        mCamera.getMatrix(mMatrix)
        mCamera.restore()
        val scale = 5
        val mValues = FloatArray(9)
        mMatrix.getValues(mValues) //获取数值
        mValues[6] = mValues[6] / scale //数值修正
        mValues[7] = mValues[7] / scale //数值修正
        mMatrix.setValues(mValues)
        canvas?.apply {
            concat(mMatrix)
            mPaint.color = Color.RED
            drawRoundRect(RectF(-paperWidth/2, 0f, paperWidth/2, paperHeight/2), 20f, 20f, mPaint)
        }

    }
}