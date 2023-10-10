package com.udacity

import android.content.Context

interface Downloader {

    //The long returned is the ID of the downloaded file
    suspend fun downloadFile (url:String, context: Context): Long

}