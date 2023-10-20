package com.udacity

import android.app.DownloadManager
import android.app.DownloadManager.Request
import android.content.Context
import android.net.Uri
import android.os.Environment
import android.util.Log
import androidx.core.content.getSystemService
import com.udacity.Util.Constants
import com.udacity.Util.Loading
import com.udacity.Util.loadingFile



lateinit var downloadManager:DownloadManager

class FileDownloader (context: Context):Downloader {

    companion object {
       var downloadID:Long = 0
    }

    init {
        downloadManager  = context.getSystemService(DownloadManager::class.java)
    }



    override suspend fun downloadFile(url: String, context: Context): Long {

//        downloadManager = context.getSystemService(DownloadManager::class.java)

        when (loadingFile) {
            Loading.GLIDE -> {
                glideRequest(url)

            }
            Loading.UDACITY -> {
                udacityRequest(url)

            }
            Loading.RETROFIT -> {
                retrofitRequest(url)
            }
            else -> {
                Log.i("FileDownloader", "No file type selected for download")
                return -1L
            }
        }
        return -1L
    }

    fun glideRequest (url: String):Long {



        val request = DownloadManager.Request(Uri.parse(url))
            .setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI)
            .setTitle("glide-master.zip")
            .setDescription(R.string.app_description.toString())
            .setRequiresCharging(false)
            .setAllowedOverMetered(true)
            .setAllowedOverRoaming(true)
            .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_ONLY_COMPLETION)
            .setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "glide-master.zip")

        Log.i("FileDownloader", "Glide download method has completed")


        downloadID = downloadManager.enqueue(request)
        return downloadID

    }

    fun udacityRequest (url: String):Long {

        val request = DownloadManager.Request(Uri.parse(url))
            .setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI)
            .setTitle("nd940-c3-advanced-android-programming-project-starter-master.zip")
            .setDescription(R.string.app_description.toString())
            .setRequiresCharging(false)
            .setAllowedOverMetered(true)
            .setAllowedOverRoaming(true)
            .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_ONLY_COMPLETION)
            .setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "nd940-c3-advanced-android-programming-project-starter-master.zip")

        Log.i("DownloaderClasses", "Glide download method has completed")


        downloadID = downloadManager.enqueue(request)
        return downloadID
    }

    fun retrofitRequest (url: String):Long {

        val request = DownloadManager.Request(Uri.parse(url))
            .setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI)
            .setTitle("retrofit-master.zip")
            .setDescription(R.string.app_description.toString())
            .setRequiresCharging(false)
            .setAllowedOverMetered(true)
            .setAllowedOverRoaming(true)
            .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_ONLY_COMPLETION)
            .setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "retrofit-master.zip")

        Log.i("DownloaderClasses", "Glide download method has completed")


        downloadID =  downloadManager.enqueue(request)
        return downloadID
    }
}

