package com.udacity.Util

import android.widget.RadioGroup
import android.widget.RadioGroup.OnCheckedChangeListener

lateinit var loadingFile:Loading

class ClickListenerOuter(var glide: Int, var udacity: Int, var retrofit: Int) :
    RadioGroup.OnCheckedChangeListener {

    //checkedId is the Integer id of the button that has been checked.
    override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {

        when (checkedId) {
            glide -> {
                loadingFile = Loading.GLIDE
            }
            udacity -> {
                loadingFile = Loading.UDACITY
            }
            retrofit -> {
                loadingFile = Loading.RETROFIT
            }
            else -> {
                loadingFile = Loading.NONE
            }
        }


    }


}