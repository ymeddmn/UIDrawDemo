package com.mage.testuidemo.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.widget.RelativeLayout
import androidx.annotation.ColorInt
import com.mage.testuidemo.Coordinate

/**
 * author  :mayong
 * function:
 * date    :2020/12/6
 **/
class PaperLayout : RelativeLayout {
    private val TAG: String = "tag"
    private val contentPaint: Paint = Paint()
    private var paperHeight = 0f
    private var paperWidth = 0f

    /**
     * 卷角在内状态
     */
    val DRAW_STATE_INNER = 0x01

    /**
     * 卷角在外状态
     */
    val DRAW_STATE_OUTER = 0x02

    var drawState = DRAW_STATE_INNER

    /**
     * 坐标点
     */
    var pointD: Coordinate =
        Coordinate()


    /**
     * 内容路径
     */
    var contentPath: Path = Path()

    @ColorInt
    var paperColor: Int = Color.WHITE
    var crimpSize: Float = 60F


    constructor(context: Context?) : this(context, null)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        initView(context, attrs)
    }

    private fun initView(context: Context?, attrs: AttributeSet?) {
        contentPaint.strokeWidth = 5f
        contentPaint.color = Color.YELLOW
        setWillNotDraw(false)
//        configPoint(350f, paperHeight-350f)
//        combinePath()
        pointD.x=350f
        pointD.y=350f
    }

    private fun combinePath() {
        if (drawState == DRAW_STATE_INNER) {
            with(contentPath) {
                contentPath.reset()
                moveTo(0f, 0f)
                lineTo(0f, pointD.y - crimpSize)
                quadTo(0f, pointD.y, crimpSize, pointD.y)
                lineTo(pointD.x, pointD.y)
                lineTo(pointD.x, paperHeight - crimpSize)
                quadTo(pointD.x, paperHeight, pointD.x + crimpSize, paperHeight)
                lineTo(paperWidth, paperHeight)
                lineTo(paperWidth, 0f)
                lineTo(0f, 0f)
                close()
            }

        }
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        paperWidth = w * 3f / 4
        paperHeight = paperWidth
//        configPoint(0f, paperHeight.toFloat())
//        combinePath()
//        configPoint(350f, paperHeight-350f)
        Log.e(TAG, "onSizeChanged: onSizeChange$width : $height")
        drawLayout()
    }


    override fun onDraw(canvas: Canvas?) {
//        super.onDraw(canvas)
        Log.e(TAG, "onDraw: 绘制开始")
        canvas?.let {
            drawPaper(it)
        }
        Log.e(TAG, "onDraw: 绘制开始")
    }

    private fun drawPaper(canvas: Canvas) {
        with(canvas) {
            save()
            when (drawState) {
                DRAW_STATE_INNER -> {
                    translate((width-paperWidth)/2,(height-paperHeight)/2)
                    contentPaint.setShadowLayer(50F, -10F, 10F, Color.BLUE)
                    contentPaint.color = Color.RED
//                    translate((width - paperWidth) / 2f, (height - paperHeight) / 2f)
                    drawPath(contentPath, contentPaint)
                    val paint = Paint()
                    paint.color = Color.YELLOW
                    paint.strokeWidth = 4f
                    drawCircle(pointD.x, pointD.y, 10f, paint)
                }
                DRAW_STATE_OUTER -> {

                }
            }

            restore()
        }
    }

    var downX = 0f
    var downY = 0f
    var dStartX = 0f
    var dStartY = 0f
    var offset = 0f
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        event?.apply {
            when (action) {
                MotionEvent.ACTION_DOWN -> {
                    downX = x
                    downY = y
                    dStartX= pointD.x
                    dStartY = pointD.y
                }
                MotionEvent.ACTION_MOVE -> {
                    offset = x-downX
                    pointD.x=dStartX+offset
                    pointD.y = dStartY-offset
                    drawLayout()
                }
                MotionEvent.ACTION_UP->{

                }
            }
        }



        return true
    }

    fun drawLayout() {
        combinePath()
        invalidate()
    }


}