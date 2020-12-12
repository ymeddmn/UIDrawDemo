package com.mage.testuidemo.activity

import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.mage.testuidemo.R
import com.mage.testuidemo.drawable.RoundDrawableBackground

class CustomDrawableActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_drawable)
        var iv1 = findViewById<ImageView>(R.id.iv_1)
        val roundDrawableBackground = RoundDrawableBackground(200f)
        roundDrawableBackground.bounds= Rect(0,0,500,500)
        iv1.setImageDrawable(roundDrawableBackground)
    }
}