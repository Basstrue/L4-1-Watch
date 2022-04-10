package com.example.watch.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.core.graphics.blue

class Watch(context: Context?, attrs: AttributeSet? = null, defStyleAttr: Int = 0):
    View(context, attrs, defStyleAttr) {

    private val painter = Paint().apply{
        color = Color.BLACK
        style = Paint.Style.STROKE
        strokeWidth = 30f
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.apply {
            val centerX = (width / 2).toFloat()
            val centerY = (height / 2).toFloat()
            drawColor(Color.GRAY)
            drawCircle(centerX,centerY,400f, painter)
            drawLine(centerX,centerY+100,centerX,centerY-200, painter)
            painter.color = Color.BLUE
            painter.strokeWidth = 20f
            drawLine(centerX-280,centerY,centerX+130,centerY, painter)
            painter.color = Color.RED
            painter.strokeWidth = 10f
            drawLine(centerX-230,centerY+230,centerX+100,centerY-100, painter)

        }
    }
}