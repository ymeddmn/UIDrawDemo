package com.mage.testuidemo.matcamera

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.View

/**
 * author  :mayong
 * function:
 * date    :2020/12/10
 **/
class MatrixView : View {
    var TAG = "matrix"
    private val paint: Paint = Paint()

    var posttranslateX = 0f
        set(value) {
            field = value
            invalidate()
        }
    var posttranslateY = 0f
        set(value) {
            field = value
            invalidate()
        }
    var preTranslateX = 0f
        set(value) {
            field = value
            invalidate()
        }
    var preTransltateY = 0f
        set(value) {
            field = value
            invalidate()
        }
    var rotationDegree = 0f
        set(value) {
            field = value
            invalidate()
        }
    var mRotationX = 0f
        set(value) {
            field = value
            invalidate()
        }
    var mRotationY = 0f
        set(value) {
            field = value
            invalidate()
        }


    var mPreDegree = 0f
        set(value) {
            field = value
            invalidate()
        }
    var mPreRotateX = 0f
        set(value) {
            field = value
            invalidate()
        }
    var mPreRotateY = 1f
        set(value) {
            field = value
            invalidate()
        }
    var mPreScaleX = 1f
        set(value) {
            field = value
            invalidate()
        }
    var mPreScaleY = 1f
        set(value) {
            field = value
            invalidate()
        }
    var mPostScalelX = 1f
        set(value) {
            field = value
            invalidate()
        }
    var mPostScaleY = 0f
        set(value) {
            field = value
            invalidate()
        }


    var mPreSkewX = 0f
        set(value) {
            field = value
            invalidate()
        }
    var mPreSkewY = 0f
        set(value) {
            field = value
            invalidate()
        }
    var mPostSkewX = 0f
        set(value) {
            field = value
            invalidate()
        }
    var mPostSkewY = 0f
        set(value) {
            field = value
            invalidate()
        }


    var mCameraRotateX = 0f
        set(value) {
            field = value
            invalidate()
        }
    var mCameraRotateY = 0f
        set(value) {
            field = value
            invalidate()
        }
    var mCameraRotateZ = 0f
        set(value) {
            field = value
            invalidate()
        }

    var mCameraTransX = 0f
        set(value) {
            field = value
            invalidate()
        }
    var mCameraTransY = 0f
        set(value) {
            field = value
            invalidate()
        }


    var mCameraLocX = 0f
        set(value) {
            field = value
            invalidate()
        }

    var mCameraLocY = 0f
        set(value) {
            field = value
            invalidate()
        }

    var mMatrix: Matrix = Matrix()
    var mCamera = Camera()

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        paint.color = Color.GREEN
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.apply {
            mMatrix.reset()
            mCamera.save()
            mCamera.rotateX(mCameraRotateX)
            mCamera.rotateY(mCameraRotateY)
            mCamera.rotateZ(mCameraRotateZ)
            mCamera.translate(getTRansX(mCameraTransX), -getTRansY(mCameraTransY), 0f)
            mCamera.setLocation(mCameraLocX,mCameraLocY, mCamera.locationZ)//x，y轴移动到中心，z轴不变
            Log.e(TAG, "onDraw: camera相机的xy位置：$mCameraLocX    $mCameraLocY")
            mCamera.getMatrix(mMatrix)
//            printMatrix(mMatrix)
            mCamera.restore()
            mMatrix.preTranslate(getTRansX(preTranslateX), getTRansY(preTransltateY))
            mMatrix.postTranslate(getTRansX(posttranslateX), getTRansY(posttranslateY))
            mMatrix.postRotate(rotationDegree, getTRansX(mRotationX), getTRansY(mRotationY))
            mMatrix.preRotate(mPreDegree, getTRansX(mPreRotateX), getTRansY(mPreRotateY))
            mMatrix.preScale(getMScale(mPreScaleX), getMScale(mPreScaleY))
            mMatrix.postScale(getMScale(mPostScalelX), getMScale(mPostScaleY))
            mMatrix.preSkew(getSkew(mPreSkewX), getSkew(mPreSkewY))
            mMatrix.postSkew(getSkew(mPostSkewX), getSkew(mPostSkewY))
            Log.e(TAG, "onDraw: x偏移$posttranslateX")
//            val scale = resources.displayMetrics.density
//            val mValues = FloatArray(9)
//            mValues[6] = mValues[6] / scale //数值修正
//            mValues[7] = mValues[7] / scale //数值修正
//            mMatrix.setValues(mValues)
            concat(mMatrix)
//            translate(width / 2f, height / 2f)
//            drawRect(Rect(-100, -100, 100, 100), paint)
//            drawRect(Rect(0, 0, 200, 200), paint)
            drawRect(Rect(0, 0, 200, 200), paint)


        }
    }



    private fun printMatrix(conMatrix: Matrix) {
        val array = FloatArray(9)
        conMatrix.getValues(array)
        println("matrix坐标打印")

        println("matrix坐标  ${array[0]}  ${array[1]}  ${array[2]}")
        println("matrix坐标  ${array[3]}  ${array[4]}  ${array[5]}")
        println("matrix坐标  ${array[6]}  ${array[7]}  ${array[8]}")


    }

    private fun getMScale(scale: Float): Float {
        var tempScale = scale / 30
        return 1 + tempScale
    }

    /**
     * 将距离的百分比转化为宽高对应的距离
     */
    private fun getTRansX(value: Float): Float {
        return value * width / 100
    }

    /**
     * 将距离的百分比转化为宽高对应的距离
     */
    private fun getTRansY(value: Float): Float {
        return value * width / 100
    }

    private fun getSkew(value: Float): Float {
        return value / 100
    }
}