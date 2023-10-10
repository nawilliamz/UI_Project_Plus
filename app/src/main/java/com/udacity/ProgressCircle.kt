package com.udacity

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import androidx.core.content.withStyledAttributes
import androidx.core.view.isGone
import androidx.core.view.isInvisible
import androidx.core.view.updateLayoutParams

class ProgressCircle @JvmOverloads constructor (
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
        ) : View(context, attrs, defStyleAttr) {


        private var width_cir = 0
        private var height_cir = 0


        private var top_cir = 0f
        private var bottom_cir = 0f
        private var left_cir = 0f
        private var right_cir = 0f

        private var circleRadius = resources.getDimension(R.dimen.circleRadius)

        private var circleOffset = circleRadius/2

        var centerWidth = 0f
        var centerHeight = 0f

        var height_cir_float = 0f
        var textHeight = 66f
        var textOffset = textHeight/2

        var positionAnimator = ValueAnimator()

        private var rect = RectF()

        private var accentColor = 0

        private var sweepAngle = 0f

        private var text_to_circle_margin = 25f



        val circlePaint = Paint (Paint.ANTI_ALIAS_FLAG).apply {
                style = Paint.Style.FILL


        }

        val textPaint = Paint (Paint.ANTI_ALIAS_FLAG).apply {
            textAlign = Paint.Align.RIGHT
            textSize = 66f
            setColor(Color.WHITE)
        }

        init {
            context.withStyledAttributes(attrs, R.styleable.LoadingButton) {
                accentColor = getColor(R.styleable.LoadingButton_accentColor, 0)


            }
        }


    suspend fun showAnimatedCircle () {
        this.isGone = false
//
        animateCircle()

    }

    fun cancelAnimatedCircle() {
        positionAnimator.cancel()
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)

        width_cir = w
        height_cir = h

        height_cir_float = h.toFloat()

        top_cir = 0f
        bottom_cir = top_cir + circleRadius
        left_cir = 0f
        right_cir = left_cir + circleRadius

        circlePaint.color = accentColor

//        centerWidth = w/2 - circleOffset
        centerWidth = (2*w/3).toFloat()
        centerHeight = h/2 - circleOffset

        textHeight = height_cir_float/2

        rect = RectF(left_cir, top_cir, right_cir, bottom_cir)


    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        circlePaint.color = accentColor

//        var sweepAngle = 270f

        centerProgressCircle(canvas)

//        canvas?.drawText(resources.getString(R.string.button_loading), 0f, 33f, textPaint)

//        canvas?.drawArc(rect, 0f, sweepAngle, true, circlePaint)

    }

//    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
//    }



    private fun animateCircle () {

        val initialPosition = 0f
        val finalPosition = 360f

        positionAnimator = ValueAnimator.ofFloat(initialPosition, finalPosition)

        //Remember, the duration must still be 5000 ms in case where no file is selected. use if statement with
        //condition using Loading enum class. If Loading.NONE, then set duration equal to 5000 ms.
//        val duration = ValueAnimator.DURATION_INFINITE

        val infiniteCircleValue = ValueAnimator.INFINITE

        positionAnimator.repeatCount = infiniteCircleValue

        positionAnimator.addUpdateListener {
               this.sweepAngle = it.animatedValue as Float
                invalidate()
        }

        positionAnimator.start()
    }

    private fun centerProgressCircle(canvas: Canvas?) {

        canvas?.translate(centerWidth, centerHeight)

        canvas?.drawArc(rect, 0f, sweepAngle, true, circlePaint)

        canvas?.drawText(context.getString(R.string.button_loading), 0f, textHeight, textPaint)
    }
}