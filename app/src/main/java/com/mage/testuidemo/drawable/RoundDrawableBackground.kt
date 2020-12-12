package com.mage.testuidemo.drawable

import android.graphics.*
import android.graphics.drawable.Drawable
import com.mage.testuidemo.App
import com.mage.testuidemo.R

/**
 * author  :mayong
 * function:
 * date    :2020/12/12
 **/

class RoundDrawableBackground : Drawable {
    private var mBitmap: Bitmap? = null
    var radius = 100f

    constructor(radius: Float) {
        this.radius = radius
        mPaint.color = Color.RED
        mPaint.style = Paint.Style.STROKE
        mPaint.strokeWidth = 5f
        mPaint.isAntiAlias = true
    }

    private val mPaint: Paint = Paint()

    var path = Path()
    var mWidth = 0f
    var mHeight = 0f
    override fun setBounds(bounds: Rect) {
        super.setBounds(bounds)
        mWidth = (bounds.right - bounds.left).toFloat()
        mHeight = (bounds.bottom - bounds.top).toFloat()
        val option = BitmapFactory.Options()
        option.outWidth = 50
        option.outHeight = 50
        var mBitmap1 =
            BitmapFactory.decodeResource(App.application.resources, R.drawable.icon1, option)
//        mBitmap= Bitmap.createBitmap(mBitmap1,0,0,100,100)
        mBitmap = Bitmap.createScaledBitmap(mBitmap1, 100, 100, false)
        invalidateSelf()
    }

    var bitmapX = 0f
    var bitmapY = 0f
    override fun draw(canvas: Canvas) {

        bounds.apply {
            canvas.translate(width() / 2f, height() / 2f)
            generateLine()
            canvas.drawPath(path, mPaint)
            mBitmap?.let {
                canvas.drawBitmap(it, bitmapX, bitmapY, mPaint)
            }
        }
    }

    private fun generateLine() {

        path.reset()
        bounds.apply {
            path.moveTo(-mWidth / 2, -mHeight / 2 + radius)
            path.arcTo(
                RectF(
                    -mWidth / 2,
                    -mHeight / 2,
                    -mWidth / 2 + radius,
                    -mHeight / 2 + radius
                ),
                -180f,
                90f
            )
            path.lineTo(mWidth / 2 - radius, -mHeight / 2)
            path.arcTo(
                RectF(mWidth / 2 - radius, -mHeight / 2, mWidth / 2, -mHeight / 2 + radius),
                -90f,
                90f
            )
            path.lineTo(mWidth / 2, mHeight / 2 - radius)
            path.arcTo(
                RectF(mWidth / 2 - radius, mHeight / 2 - radius, mWidth / 2, mHeight / 2),
                0f,
                90f
            )
            path.lineTo(-mWidth / 2 + radius, mHeight / 2)
            path.arcTo(
                RectF(-mWidth / 2, mHeight / 2 - radius, -mWidth / 2 + radius, mHeight / 2),
                90f,
                90f
            )
            path.lineTo(-mWidth / 2, -mHeight / 2 + radius)
            path.close()
        }
    }

    var mState = State.LEFT


    fun calcuateIconPoint() {

    }

    override fun setAlpha(alpha: Int) {
    }

    override fun getOpacity(): Int {
        return PixelFormat.TRANSLUCENT
    }


    override fun setColorFilter(colorFilter: ColorFilter?) {
    }

    enum class State {
        LEFT, RIGHT, TOP, BOTTOM
    }

}