package com.udacity

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.core.content.withStyledAttributes
import com.udacity.databinding.ActivityMainBinding
import kotlin.math.min
import kotlin.properties.Delegates

class LoadingButton @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

//    private var binding:ActivityMainBinding = ActivityMainBinding.inflate(LayoutInflater)


//    override fun setOnCreateContextMenuListener(l: OnCreateContextMenuListener?) {
//        super.setOnCreateContextMenuListener(l)
//
//        binding = ActivityMainBinding.inflate(LayoutInflater.from(context))
//    }




//    private var widthSize = 0
//    private var heightSize = 0
    var buttonPrimaryColor = 0
    var buttonDownloadColor = 0

    val rect = RectF()

    private var width = 0F
    private var height = 0F

//    private var buttonTop = 0F
//    private var buttonBottom = 0F
//    private var buttonLeft = 0F
//    private var buttonRight = 0F

    private var textWidth = 0F
    private var textHeight = 0F

    private var radius = 0F


    val buttonPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL


    }
    val textPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        textAlign = Paint.Align.CENTER
        textSize = 66.0f
        setColor(Color.WHITE)

//        typeface = Typeface.create( "", Typeface.BOLD)
    }

    val textPaint2 = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        textAlign = Paint.Align.CENTER
        textSize = 66.0f
//        typeface = Typeface.create( "", Typeface.BOLD)
    }

    val circlePaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
    }

    private val valueAnimator = ValueAnimator()

    //Note the separate class for ButtonState
    private var buttonState: ButtonState by Delegates.observable<ButtonState>(ButtonState.Completed) { p, old, new ->


    }


    init {
        isClickable = true



        context.withStyledAttributes(attrs, R.styleable.LoadingButton) {
            buttonPrimaryColor = getColor(R.styleable.LoadingButton_primaryButtonColor, 0)
            buttonDownloadColor = getColor(R.styleable.LoadingButton_downloadButtonColor, 0)

        }

    }


    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)

        width = w.toFloat()
        height = h.toFloat()

        rect.top = 0F
        rect.bottom = rect.top + height
        rect.left = 0F
        rect.right = rect.left + width

        textWidth = width/2
        textHeight = height/2

        radius = textPaint2.textSize/2


    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        buttonPaint.color = buttonPrimaryColor
        canvas?.drawRect(rect.left, rect.top, rect.right, rect.bottom, buttonPaint)

        if (canvas != null) {
            drawButtonPreDLText(canvas)
            
//            drawButtonDownloadingText(canvas)

//            drawStatusCircle(canvas)
        }

    }


    fun setOnDownloadClickListener (listener: () -> Unit) {



            this.setOnClickListener( {
                listener.invoke()
            })
    }


//    override fun performClick(): Boolean {
//        if (super.performClick()) return true
//
//        ValueAnimator.ofFloat(rect.left, rect.right).apply {
//
//            addUpdateListener {
//                duration = 1000
//
//                start()
//            }
//
//        }
//
//
//    }





    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val minw: Int = paddingLeft + paddingRight + suggestedMinimumWidth
        val w: Int = resolveSizeAndState(minw, widthMeasureSpec, 1)
        val h: Int = resolveSizeAndState(
            MeasureSpec.getSize(w),
            heightMeasureSpec,
            0
        )
//        widthSize = w
//        heightSize = h
        setMeasuredDimension(w, h)
    }

    private fun drawButtonPreDLText (canvas:Canvas) {

        canvas.translate(textWidth, textHeight)
        canvas.save()

        canvas.drawText("DOWNLOAD", 0F,33F, textPaint)


        canvas.restore()

    }

    private fun drawButtonDownloadingText (canvas:Canvas) {

        canvas.translate(textWidth, textHeight)
        canvas.save()

        canvas.drawText("We are Loading", 0F,0F, textPaint2)

        canvas.restore()

    }

    private fun drawStatusCircle (canvas:Canvas) {

        canvas.translate(textWidth, textHeight)
        canvas.save()

        canvas.drawCircle(0F, 0F, radius, circlePaint)

        canvas.restore()

    }

}