package com.udacity.Util

import android.app.NotificationManager
import android.content.Context
import androidx.core.app.NotificationCompat
import com.udacity.R



    private val NOTIFICATION_ID = 0
    private val REQUEST_CODE = 0
    private val FLAGS = 0


    fun NotificationManager.sendNotification(messageBody:String, applicationContext:Context) {


        val builder = NotificationCompat.Builder(
            applicationContext,
            applicationContext.getString(R.string.download_channel_id))


                //set these 4 notification items (this is required minimum for a notification)
                .setSmallIcon(R.drawable.notif_img_ldpi)
                .setContentTitle(applicationContext.getString(R.string.notification_title))
                .setContentText(messageBody)


        notify(NOTIFICATION_ID, builder.build())
    }


