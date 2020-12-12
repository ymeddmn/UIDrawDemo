package com.mage.testuidemo.matcamera

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.View
import com.mage.testuidemo.R


/**
 * author  :mayong
 * function:
 * date    :2020/12/9
 **/
class MatCameraView : View {
    private val TAG: String="MatCameraView"
    private var rect: Rect = Rect()
    var mCamera: Camera = Camera()
    var mPaint: Paint = Paint()
    var mMatrix: Matrix = Matrix()
    var mRotationY =0f
        set(value) {
            field=value
            print("rotationY值：$value")
            invalidate()
        }
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        mPaint.color = Color.RED
        mPaint.isAntiAlias = false
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.apply {
            mMatrix.reset();
            mCamera.save();
//            mCamera.translate(120f,20f,0f)
            mCamera.rotateY(mRotationY)
            mCamera.getMatrix(mMatrix)
            mCamera.restore()
//            mMatrix.preTranslate(-width / 2f,0f)
//            mMatrix.postTranslate(width / 2f, 0f)

            mMatrix.preTranslate(-200f,80f)
//            mMatrix.postTranslate(200f, 300f)
            concat(mMatrix)
            drawRect(Rect(0, 0, 200, 200), mPaint)
            Log.e(TAG, "onDraw: ${mCamera.locationX} : ${mCamera.locationY} : ${mCamera.locationZ}")

        }
    }

}