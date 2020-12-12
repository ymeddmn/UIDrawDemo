package com.mage.testuidemo.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import com.mage.testuidemo.R
import com.mage.testuidemo.matcamera.Matirx1View

class Matrix1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_matrix1)
        val seekbar = findViewById<SeekBar>(R.id.seekbar)
        var matirx1View =findViewById<Matirx1View>(R.id.matrix)
        seekbar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                matirx1View.mRotateX= (progress*180/100).toFloat()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

        })
    }
}