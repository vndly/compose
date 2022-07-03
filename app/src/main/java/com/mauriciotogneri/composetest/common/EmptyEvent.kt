package com.mauriciotogneri.composetest.common

import androidx.lifecycle.LifecycleOwner

class EmptyEvent : Event<Nothing?>() {
    fun send() = postValue(null)

    fun register(lifecycleOwner: LifecycleOwner, observer: () -> Unit) = observe(lifecycleOwner) { observer() }
}