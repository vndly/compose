package com.mauriciotogneri.composetest.counter.state

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.mauriciotogneri.composetest.base.BaseState
import com.mauriciotogneri.composetest.counter.model.Counter

class CounterState(private val callback: CounterStateCallback) : BaseState() {
    var counter by mutableStateOf(Counter())

    fun increaseCounter() {
        counter = Counter(counter.value + 1)
    }

    fun openNewScreen() = callback.onOpenNewScreen("https://foo.com/image")
}

class CounterStateFactory(
    private val lifecycle: ViewModelStoreOwner,
    private val callback: CounterStateCallback,
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T = CounterState(callback) as T

    fun get() = ViewModelProvider(lifecycle, this).get(CounterState::class.java)
}

interface CounterStateCallback {
    fun onOpenNewScreen(url: String)
}