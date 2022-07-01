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

    val onOpenImageScreen = MutableLiveData<String>()
    val onOpenCoroutinesScreen = MutableLiveData<Nothing?>()

    fun increaseCounter() {
        counter = Counter(counter.value + 1)
    }

    fun openImageScreen() = onOpenImageScreen.postValue("https://foo.com/image")

    fun openCoroutinesScreen() = onOpenCoroutinesScreen.postValue(null)
}

class CounterStateFactory(
    private val lifecycle: ViewModelStoreOwner,
) {
    fun get() = ViewModelProvider(lifecycle).get(CounterState::class.java)
}