package com.udacity.Util

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.util.Log
import androidx.core.app.NotificationCompat
import com.udacity.*


private val NOTIFICATION_ID = 0
    private val REQUEST_CODE = 0
    private val FLAGS = 0


    fun NotificationManager.sendNotification(messageBody:String, applicationContext:Context) {

//        val downloadIntent = Intent(applicationContext, DetailActivity::class.java).also {
//            it.putExtra("FILENAME", fileName)
//            Log.i("NotificationUtil", "File name value is $fileName")
//            it.putExtra("STATUS", fileDownloadStatus)
//            Log.i("NotificationUtil", "Download status value is $fileDownloadStatus")
//
//            //Don't need StartActivity here unless it is for a result
//        }

        val notificationImage = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.notif_img_mdpi)
        val bigPicStyle = NotificationCompat.BigPictureStyle()
            .bigPicture(notificationImage)
            .bigLargeIcon(notificationImage)




        val downloadtPendingIntent = PendingIntent.getActivity(
            applicationContext,
            NOTIFICATION_ID,
            downloadIntent,
            PendingIntent.FLAG_UPDATE_CURRENT)


        val builder = NotificationCompat.Builder(
            applicationContext,
            applicationContext.getString(R.string.download_channel_id))


                //set these 4 notification items (this is required minimum for a notification)
                .setSmallIcon(R.drawable.notif_img_ldpi)
                .setContentTitle(applicationContext.getString(R.string.notification_title))
                .setContentText(messageBody)
                .setContentIntent(downloadtPendingIntent)
                .setStyle(bigPicStyle)
                .setLargeIcon(notificationImage)
                .setAutoCancel(true)


        notify(NOTIFICATION_ID, builder.build())
    }


