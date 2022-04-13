package com.example.watch.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class Watch(context: Context?, attrs: AttributeSet? = null, defStyleAttr: Int = 0):
    View(context, attrs, defStyleAttr) {
    private var radius: Float = 400f
    private var target: Int = 0
    private val painter = Paint().apply{ isAntiAlias = true }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.translate((width/2).toFloat(), (height/2).toFloat())
        canvas?.drawColor(Color.GRAY)
        painter.color = Color.BLACK
        painter.style = Paint.Style.STROKE
        painter.strokeWidth = 30f
        canvas?.drawCircle(0f, 0f, 20f, painter)
        canvas?.drawCircle(0f, 0f, radius, painter)
        target--
        canvas?.drawLine(0f, 0f, (Math.cos(Math.PI - (Math.PI*2/60)*target/360) * (radius-150f)).toFloat(), (Math.sin(Math.PI - (Math.PI*2/60)*target/360) * (radius-150f)).toFloat(), painter)

        for (i in 0..12 step 1){
            val x1: Float = (Math.cos(Math.PI - (Math.PI*2/12)*i) * radius).toFloat()
            val y1: Float = (Math.sin(Math.PI - (Math.PI*2/12)*i) * radius).toFloat()
            val x2: Float = x1 * 0.8f
            val y2: Float = y1 * 0.8f
            canvas?.drawLine(x1, y1, x2, y2, painter)}

        painter.color = Color.RED
        painter.strokeWidth = 10f
        canvas?.drawLine(0f, 0f, (Math.cos(Math.PI - (Math.PI*2/60)*target) * (radius-50f)).toFloat(), (Math.sin(Math.PI - (Math.PI*2/60)*target) * (radius-50f)).toFloat(), painter)

        painter.color = Color.BLUE
        painter.strokeWidth = 20f
        canvas?.drawLine(0f, 0f, (Math.cos(Math.PI - (Math.PI*2/60)*target/60) * (radius-50f)).toFloat(), (Math.sin(Math.PI - (Math.PI*2/60)*target/60) * (radius-50f)).toFloat(), painter)

        postInvalidateDelayed(1000)
    }
}