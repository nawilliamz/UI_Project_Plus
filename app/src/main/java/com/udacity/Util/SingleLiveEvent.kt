package com.udacity.Util

import android.util.Log
import androidx.annotation.MainThread
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import java.util.concurrent.atomic.AtomicBoolean

class SingleLiveEvent<T> : MutableLiveData<T>() {

    //Atomic is a phrase that is associated with the concept of Concurrency.
    //Atomic means only one thread accessess the variable (static type). Atomic is threadsafe, but
    //it is slow. Nonatomic means multiple threads access the same variable (dynamic type).

    private val pending = AtomicBoolean(false)

    @MainThread
    override fun observe(owner: LifecycleOwner, observer: Observer<in T>) {

        if (hasActiveObservers()) {
            Log.e("TAG", "Multiple observers registered but only one will be notified of changes.")
        }

        super.observe(owner, { t ->

            //Atomically sets the value to newValue if current value == expected value, with memory effects
            //specified by VarHandle#compareAndSet
            //compareAndSet() returns true if the expected value equals the inital value; if this hapopens
            //then the value is also updated to the new value (false in this case)
            if (pending.compareAndSet(true, false)) {
                observer.onChanged(t)
            }
        })
    }

    @MainThread
    override fun setValue(t: T?) {
        pending.set(true)
        super.setValue(t)
    }

    //value is the value contained by the LiveData
    @MainThread
    fun call() {
        value = null
    }
}