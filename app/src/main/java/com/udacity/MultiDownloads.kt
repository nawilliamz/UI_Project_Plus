package com.udacity

import android.app.DownloadManager
import android.content.Context
import android.net.Uri
import android.os.Environment


//class MultiDownloads(context: Context): Downloader {

//    val downloadManager = context.getSystemService(DownloadManager::class.java)
//
//    companion object {
//
//        const val glideURL = "https://github.com/bumptech/glide"
//        const val udacityURL = "https://github.com/udacity/nd940-c3-advanced-android-programming-project-starter"
//        const val retrofitURL = "https://github.com/square/retrofit"
//
//        const val glideTitle = "glide-master.zip"
//        const val udacityTitle = "nd940-c3-advanced-android-programming-project-starter-master.zip"
//        const val retrofitTitle = "https://github.com/square/retrofit"
//
////        private const val CHANNEL_ID = "glideId"
//    }
//
//    override fun downloadFile(url: String): Long {
//
//        var title = ""
//
//        when (url) {
//            glideURL -> title = glideTitle
//            udacityURL  -> title = udacityTitle
//            retrofitURL  -> title = retrofitTitle
//        }
//
//        val request = DownloadManager.Request(Uri.parse(url))
//            .setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI)
//            .setAllowedNetworkTypes(DownloadManager.Request.NETWORK_MOBILE)
//            .setTitle(title)
//            .setDescription(R.string.app_description.toString())
//            .setRequiresCharging(false)
//            .setAllowedOverMetered(true)
//            .setAllowedOverRoaming(true)
//            .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_ONLY_COMPLETION)
//            .setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, title)
//
//        return downloadManager.enqueue(request)
//    }

//}