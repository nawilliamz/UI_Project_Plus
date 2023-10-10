package com.udacity.Util

sealed class Events {
    object Loading : Events()

    object Done : Events()
}
