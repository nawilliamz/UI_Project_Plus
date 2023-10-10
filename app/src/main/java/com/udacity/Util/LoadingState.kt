package com.udacity.Util

import androidx.lifecycle.MutableLiveData

open class LoadingState<T : LoadingStatus>:MutableLiveData<T>() {

    private var _loadingStatus = MutableLiveData<T>()
    val loadingStatus: MutableLiveData<T>
        get() = _loadingStatus

}