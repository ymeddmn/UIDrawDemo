package com.mage.testuidemo.view

import android.app.Activity
import android.graphics.Bitmap
import android.graphics.Camera
import android.graphics.Matrix
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import android.widget.TextView
import com.mage.testuidemo.R


class ActCamera : Activity(), OnSeekBarChangeListener {
    private var camera: Camera = Camera()

    // views
    private var seekbarXRotate: SeekBar? = null
    private var seekbarYRotate: SeekBar? = null
    private var seekbarZRotate: SeekBar? = null
    private var txtXRotate: TextView? = null
    private var txtYRotate: TextView? = null
    private var txtZRotate: TextView? = null
    private var seekbarXSkew: SeekBar? = null
    private var seekbarYSkew: SeekBar? = null
    private var seekbarZTranslate: SeekBar? = null
    private var txtXTranslate: TextView? = null
    private var txtYTranslate: TextView? = null
    private var txtZTranslate: TextView? = null
    private var imgResult: ImageView? = null

    // integer params
    private var rotateX = 0
    private var rotateY = 0
    private var rotateZ = 0
    private var skewX = 0f
    private var skewY = 0f
    private var translateZ = 0

    /** Called when the activity is first created.  */
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_camera)
        // camera
        // initViews
        // rotate
        seekbarXRotate = findViewById<View>(R.id.seekbarXRotate) as SeekBar
        seekbarXRotate!!.setOnSeekBarChangeListener(this)
        seekbarYRotate = findViewById<View>(R.id.seekbarYRotate) as SeekBar
        seekbarYRotate!!.setOnSeekBarChangeListener(this)
        seekbarZRotate = findViewById<View>(R.id.seekbarZRotate) as SeekBar
        seekbarZRotate!!.setOnSeekBarChangeListener(this)
        txtXRotate = findViewById<View>(R.id.txtXRotate) as TextView
        txtYRotate = findViewById<View>(R.id.txtYRotate) as TextView
        txtZRotate = findViewById<View>(R.id.txtZRotate) as TextView
        // translate
        seekbarXSkew = findViewById<View>(R.id.seekbarXSkew) as SeekBar
        seekbarXSkew!!.setOnSeekBarChangeListener(this)
        seekbarYSkew = findViewById<View>(R.id.seekbarYSkew) as SeekBar
        seekbarYSkew!!.setOnSeekBarChangeListener(this)
        seekbarZTranslate = findViewById<View>(R.id.seekbarZTranslate) as SeekBar
        seekbarZTranslate!!.setOnSeekBarChangeListener(this)
        txtXTranslate = findViewById<View>(R.id.txtXSkew) as TextView
        txtYTranslate = findViewById<View>(R.id.txtYSkew) as TextView
        txtZTranslate = findViewById<View>(R.id.txtZTranslate) as TextView
        imgResult = findViewById<View>(R.id.imgResult) as ImageView
        // refresh
        refreshImage()
    }

    private fun refreshImage() {
        // 获取待处理的图像
        val tmpBitDra =
            resources.getDrawable(R.drawable.icon1) as BitmapDrawable
        val tmpBit = tmpBitDra.bitmap
        // 开始处理图像
        // 1.获取处理矩阵
        // 记录一下初始状态。save()和restore()可以将图像过渡得柔和一些。
        // Each save should be balanced with a call to restore().
        camera.save()
        val matrix = Matrix()
        // rotate
        camera.rotateX(rotateX.toFloat())
        camera.rotateY(rotateY.toFloat())
        camera.rotateZ(rotateZ.toFloat())
        // translate
        camera.translate(0f, 0f, translateZ.toFloat())
        camera.getMatrix(matrix)
        // 恢复到之前的初始状态。
        camera.restore()
        // 设置图像处理的中心点
        matrix.preTranslate((tmpBit.width shr 1).toFloat(), (tmpBit.height shr 1).toFloat())
        matrix.preSkew(skewX, skewY)
        // matrix.postSkew(skewX, skewY);
        // 直接setSkew()，则前面处理的rotate()、translate()等等都将无效。
        // matrix.setSkew(skewX, skewY);
        // 2.通过矩阵生成新图像(或直接作用于Canvas)
        Log.d("ANDROID_LAB", "width=" + tmpBit.width + " height=" + tmpBit.height)
        var newBit: Bitmap? = null
        try {
            // 经过矩阵转换后的图像宽高有可能不大于0，此时会抛出IllegalArgumentException
            newBit = Bitmap.createBitmap(
                tmpBit,
                0,
                0,
                tmpBit.width,
                tmpBit.height,
                matrix,
                true
            )
        } catch (iae: IllegalArgumentException) {
            iae.printStackTrace()
        }
        if (newBit != null) {
            imgResult?.setImageBitmap(newBit)
        }
    }

    override fun onProgressChanged(
        seekBar: SeekBar,
        progress: Int,
        fromUser: Boolean
    ) {
        if (seekBar === seekbarXRotate) {
            txtXRotate!!.text = "$progress゜"
            rotateX = progress
        } else if (seekBar === seekbarYRotate) {
            txtYRotate!!.text = "$progress゜"
            rotateY = progress
        } else if (seekBar === seekbarZRotate) {
            txtZRotate!!.text = "$progress゜"
            rotateZ = progress
        } else if (seekBar === seekbarXSkew) {
            skewX = (progress - 100) * 1.0f / 100
            txtXTranslate!!.text = skewX.toString()
        } else if (seekBar === seekbarYSkew) {
            skewY = (progress - 100) * 1.0f / 100
            txtYTranslate!!.text = skewY.toString()
        } else if (seekBar === seekbarZTranslate) {
            translateZ = progress - 100
            txtZTranslate!!.text = translateZ.toString()
        }
        refreshImage()
    }

    override fun onStartTrackingTouch(seekBar: SeekBar) {}
    override fun onStopTrackingTouch(seekBar: SeekBar) {}
}