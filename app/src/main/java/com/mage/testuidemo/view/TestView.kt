package com.mage.testuidemo.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.widget.RelativeLayout

/**
 * author  :mayong
 * function:
 * date    :2020/12/7
 **/
class TestView : RelativeLayout {
    var paint = Paint()
    constructor(context: Context) : this(context, null)
    constructor(context: Context, attributes: AttributeSet?) : super(context, attributes) {

        setWillNotDraw(false)

    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        paint.color = Color.GREEN
        var p1 = Path()
//        p1.fillType=Path.FillType.WINDING
        p1.fillType=Path.FillType.EVEN_ODD
//        p1.fillType=Path.FillType.INVERSE_WINDING
//        p1.fillType=Path.FillType.WINDING
        generatePath(p1, 0f)
        canvas?.drawPath(p1, paint)
    }

    private fun generatePath(p1: Path, offset: Float) {
        p1.reset()
        p1.apply {
            moveTo(20f, 20f + offset)
            lineTo(500f, offset)
            paint.color=Color.BLUE
            lineTo(100f, 580f + offset)
            close()
        }
    }
}