package com.udacity

import android.app.DownloadManager
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.Util.Events
import com.udacity.Util.LoadingStatus
import com.udacity.Util.SingleLiveEvent



//private var _loadingState = MutableLiveData<LoadingStatus>()
//val loadingState:LiveData<LoadingStatus>
//    get() = _loadingState


class MainViewModel() : ViewModel() {

    val _events = SingleLiveEvent<Events>()
    val events = _events as LiveData<Events>




    fun resetDownloadManager(downloadManager: DownloadManager) {

        //Clear outstanding downloads from the DownloadManager
        downloadManager.remove()
    }

}