package com.mauriciotogneri.composetest.common

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData

open class Event<T> : MutableLiveData<T>() {
    fun send(value: T) = postValue(value)

    fun register(lifecycleOwner: LifecycleOwner, observer: (T) -> Unit) = observe(lifecycleOwner, observer)
}