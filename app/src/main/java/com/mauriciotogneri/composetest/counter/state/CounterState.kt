package com.mauriciotogneri.composetest.counter.state

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.mauriciotogneri.composetest.base.BaseState
import com.mauriciotogneri.composetest.base.Event
import com.mauriciotogneri.composetest.counter.model.Counter

class CounterState : BaseState() {
    var counter by mutableStateOf(Counter())

    val onOpenScreen = MutableLiveData<String>()

    fun increaseCounter() {
        counter = Counter(counter.value + 1)
    }

    fun openNewScreen() = onOpenScreen.postValue("https://foo.com/image")
}

class CounterStateFactory(
    private val lifecycle: ViewModelStoreOwner,
) {
    fun get() = ViewModelProvider(lifecycle).get(CounterState::class.java)
}