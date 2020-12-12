package com.mage.testuidemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.mage.testuidemo.activity.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btn_fjye).setOnClickListener {
            startActivity(Intent(this,
                Matrix1Activity::class.java))
        }
        findViewById<Button>(R.id.btn_matrixeffect).setOnClickListener {
            startActivity(Intent(this,
                MatrixActivity::class.java))
        }
        findViewById<Button>(R.id.btn_clock).setOnClickListener {
            startActivity(Intent(this,
                ThirdActivity::class.java))
        }
        findViewById<Button>(R.id.btn_shadow).setOnClickListener {
            startActivity(Intent(this,
                ShadowActivity::class.java))
        }

        findViewById<Button>(R.id.btn_drawable).setOnClickListener {
            startActivity(Intent(this,
                CustomDrawableActivity::class.java))
        }
    }
}