package com.mauriciotogneri.composetest.screens.counter.state

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.mauriciotogneri.composetest.base.BaseState
import com.mauriciotogneri.composetest.screens.counter.model.Counter

class CounterState : BaseState() {
    var counter by mutableStateOf(Counter())

    val onOpenImageScreen = Event<String>()
    val onOpenCoroutinesScreen = EmptyEvent()

    fun increaseCounter() {
        counter = Counter(counter.value + 1)
    }

    fun openImageScreen() = onOpenImageScreen.send("https://foo.com/image")

    fun openCoroutinesScreen() = onOpenCoroutinesScreen.send()
}

class CounterStateFactory(
    private val lifecycle: ViewModelStoreOwner,
) {
    fun get() = ViewModelProvider(lifecycle).get(CounterState::class.java)
}

open class Event<T> : MutableLiveData<T>() {
    fun send(value: T) = postValue(value)
}

class EmptyEvent : Event<Nothing?>() {
    fun send() = postValue(null)
}