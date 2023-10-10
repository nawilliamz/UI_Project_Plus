package com.udacity

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import androidx.core.content.withStyledAttributes
import androidx.core.view.isGone
import androidx.core.view.isVisible

class SelectFileButton @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {


    private var width = 0F
    private var height = 0F

    private var textWidth = 0F
    private var textHeight = 0F

    private var top = 0f
    private var bottom = 0f
    private var left = 0f
    private var right = 0f

    private var primaryColor = 0


    val rect = RectF()

    val selectFilePaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL

//        textAlign = Paint.Align.CENTER
//        textSize = 66.0f
//        typeface = Typeface.create( "", Typeface.BOLD)
    }

    val textPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        textAlign = Paint.Align.CENTER
        textSize = 66.0f
        setColor(Color.BLACK)
    }


    init {
        context.withStyledAttributes(attrs, R.styleable.LoadingButton) {
            primaryColor = getColor(R.styleable.LoadingButton_primaryColor, 0)

        }

        this.alpha = .8f

    }

    suspend fun showSelectFileButton () {
        this.isVisible = true

    }


    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)

        width = w.toFloat()
        height = h.toFloat()

        top = 0F
        bottom = top + height
        left = 0F
        right = left + width

        textWidth = width/2
        textHeight = height/2
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

            selectFilePaint.color = primaryColor

//            canvas?.drawRect(left, top, right, bottom, selectFilePaint)
            canvas?.drawRoundRect(left, top, right, bottom, 60f, 60f, selectFilePaint)

        if (canvas != null) {
            selectFileText(canvas)
        }

            setBackgroundResource(R.drawable.rectangle_rounded_corners)
    }


    private fun selectFileText (canvas:Canvas) {

        canvas.translate(textWidth, textHeight)
        canvas.save()

        canvas.drawText("Select file to download", 0F,33F, textPaint)

        canvas.restore()

    }
}