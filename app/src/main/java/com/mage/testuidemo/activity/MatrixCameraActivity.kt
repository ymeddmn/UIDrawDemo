package com.mage.testuidemo.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import com.mage.testuidemo.R
import com.mage.testuidemo.matcamera.MatCameraView

class MatrixCameraActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_matrix_camera)
        val seekBarRotationY = findViewById<SeekBar>(R.id.seek_rotationy)
        val cameraView = findViewById<MatCameraView>(R.id.matcamera)
        seekBarRotationY.setOnSeekBarChangeListener(object :SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
               cameraView.mRotationY=360*progress/100f
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }


        })
    }
}