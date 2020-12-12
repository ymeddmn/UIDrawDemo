package com.mage.testuidemo.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import com.mage.testuidemo.R
import com.mage.testuidemo.view.ShadowView


class ShadowActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shadow)
        var shadowView = findViewById<ShadowView>(R.id.shadowview)
        var mshadowX = findViewById<SeekBar>(R.id.shadowX)
        var mshadowY = findViewById<SeekBar>(R.id.shadowY)
        val seekBar = findViewById<SeekBar>(R.id.shawow_seekbar)
        var listener = object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                when (seekBar?.id) {
                    R.id.shawow_seekbar -> {
                        shadowView?.mShadow = progress.toFloat()
                    }
                    R.id.shadowX -> {
                        shadowView?.mshadowX = progress.toFloat()
                    }
                    R.id.shadowY -> {
                        shadowView?.mshadowY = progress.toFloat()
                    }
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

        }
        seekBar.setOnSeekBarChangeListener(listener)
        mshadowX.setOnSeekBarChangeListener(listener)
        mshadowY.setOnSeekBarChangeListener(listener)

    }
}