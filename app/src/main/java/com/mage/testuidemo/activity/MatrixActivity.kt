package com.mage.testuidemo.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.SeekBar
import android.widget.TextView
import com.mage.testuidemo.R
import com.mage.testuidemo.matcamera.MatrixView

class MatrixActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_matrix)
        matrixView = findViewById<MatrixView>(R.id.matrix)
        findView(R.id.rotationX).setOnSeekBarChangeListener(listener)
        findView(R.id.rotationY).setOnSeekBarChangeListener(listener)
        findView(R.id.translationX).setOnSeekBarChangeListener(listener)
        findView(R.id.translationY).setOnSeekBarChangeListener(listener)
        findView(R.id.preTranX).setOnSeekBarChangeListener(listener)
        findView(R.id.preTransY).setOnSeekBarChangeListener(listener)
        findView(R.id.degree).setOnSeekBarChangeListener(listener)
        findView(R.id.preDegree).setOnSeekBarChangeListener(listener)
        findView(R.id.preRotateX).setOnSeekBarChangeListener(listener)
        findView(R.id.preRotateY).setOnSeekBarChangeListener(listener)
        findView(R.id.preScaleX).setOnSeekBarChangeListener(listener)
        findView(R.id.preScaleY).setOnSeekBarChangeListener(listener)
        findView(R.id.postScaleX).setOnSeekBarChangeListener(listener)
        findView(R.id.postScaleY).setOnSeekBarChangeListener(listener)
        findView(R.id.preSkewX).setOnSeekBarChangeListener(listener)
        findView(R.id.preSkewY).setOnSeekBarChangeListener(listener)
        findView(R.id.postSkewX).setOnSeekBarChangeListener(listener)
        findView(R.id.postSkewY).setOnSeekBarChangeListener(listener)
        findView(R.id.cameraRotateX).setOnSeekBarChangeListener(listener)
        findView(R.id.cameraRotateY).setOnSeekBarChangeListener(listener)
        findView(R.id.cameraRotateZ).setOnSeekBarChangeListener(listener)
        findView(R.id.cameraTranslationX).setOnSeekBarChangeListener(listener)
        findView(R.id.cameraTranslationY).setOnSeekBarChangeListener(listener)
        findView(R.id.cameraLocaX1).setOnSeekBarChangeListener(listener)
        findView(R.id.cameraLocaX2).setOnSeekBarChangeListener(listener)
        findView(R.id.cameraLocaY1).setOnSeekBarChangeListener(listener)
        findView(R.id.cameraLocaY2).setOnSeekBarChangeListener(listener)
         cameraXyLoc = findViewById<TextView>(R.id.tv_camlocxy)
        Unit
    }

    private var cameraXyLoc: TextView?=null
    private var matrixView: MatrixView? = null
    var listener = object : SeekBar.OnSeekBarChangeListener {
        override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
            Log.e("matrix", "onProgressChanged: seekbar进度$progress")
            when (seekBar?.id) {
                R.id.rotationX -> {
//                    matrixView?.rotationDegree=(360*progress/100).toFloat()
                    matrixView?.mRotationX = progress.toFloat()
                }
                R.id.rotationY -> {
                    matrixView?.mRotationY = progress.toFloat()
                }
                R.id.translationX -> {
                    matrixView?.posttranslateX = progress.toFloat()
//                    matrixView?.preTranslateX=-progress.toFloat()
                }
                R.id.translationY -> {
                    matrixView?.posttranslateY = progress.toFloat()
                }
                R.id.preTranX -> {
                    matrixView?.preTranslateX = progress.toFloat()
                }
                R.id.preTransY -> {
                    matrixView?.preTransltateY = progress.toFloat()
                }
                R.id.degree -> {
                    matrixView?.rotationDegree = (360 * progress / 100).toFloat()
                }


                R.id.preDegree -> {
                    matrixView?.mPreDegree = (360 * progress / 100).toFloat()
                }
                R.id.preRotateX -> {
                    matrixView?.mPreRotateX = progress.toFloat()
                }
                R.id.preRotateY -> {
                    matrixView?.mPreRotateY = progress.toFloat()
                }
                R.id.preScaleX -> {
                    matrixView?.mPreScaleX = progress.toFloat()
                }
                R.id.preScaleY -> {
                    matrixView?.mPreScaleY = progress.toFloat()
                }
                R.id.postScaleX -> {
                    matrixView?.mPostScalelX = progress.toFloat()
                }
                R.id.postScaleY -> {
                    matrixView?.mPostScaleY = progress.toFloat()
                }


                R.id.preSkewX -> {
                    matrixView?.mPreSkewX = progress.toFloat()
                }
                R.id.preSkewY -> {
                    matrixView?.mPreSkewY = progress.toFloat()
                }
                R.id.postSkewX -> {
                    matrixView?.mPostSkewX = progress.toFloat()
                }
                R.id.postSkewY -> {
                    matrixView?.mPostSkewY = progress.toFloat()
                }
                R.id.cameraRotateX -> {
                    matrixView?.mCameraRotateX = (360 * progress / 100).toFloat()
                }
                R.id.cameraRotateY -> {
                    matrixView?.mCameraRotateY = (360 * progress / 100).toFloat()
                }
                R.id.cameraRotateZ -> {
                    matrixView?.mCameraRotateZ = (360 * progress / 100).toFloat()
                }
                R.id.cameraTranslationX -> {
                    matrixView?.mCameraTransX = progress.toFloat()
                }
                R.id.cameraTranslationY -> {
                    matrixView?.mCameraTransY = progress.toFloat()
                }

                R.id.cameraLocaX1 -> {
                    matrixView?.mCameraLocX = (progress / 5f)
                    cameraXyLoc?.text=(progress / 5f).toString()
                }
                R.id.cameraLocaX2 -> {
                    matrixView?.mCameraLocX = -(progress / 5f)
                    cameraXyLoc?.text=(-(progress / 5f)).toString()
                }
                R.id.cameraLocaY1 -> {
                    matrixView?.mCameraLocY = (progress / 5f)
                    cameraXyLoc?.text=(progress / 5f).toString()
                }
                R.id.cameraLocaY2 -> {
                    matrixView?.mCameraLocY = -(progress / 5f)
                    cameraXyLoc?.text=(-(progress / 5f)).toString()
                }
            }
        }

        override fun onStartTrackingTouch(seekBar: SeekBar?) {
        }

        override fun onStopTrackingTouch(seekBar: SeekBar?) {
        }

    }

    private fun findView(id: Int): SeekBar {
        return findViewById(id)
    }
}