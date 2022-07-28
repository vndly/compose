package com.mauriciotogneri.composetest.screens.counter.state

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.mauriciotogneri.composetest.api.TodoApi
import com.mauriciotogneri.composetest.base.BaseState
import com.mauriciotogneri.composetest.common.EmptyEvent
import com.mauriciotogneri.composetest.common.Event
import com.mauriciotogneri.composetest.screens.counter.model.Counter

class CounterState : BaseState() {
    var counter by mutableStateOf(Counter())

    val onOpenImageScreen = Event<String>()
    val onOpenCoroutinesScreen = EmptyEvent()
    val onShowToast = Event<String>()

    fun increaseCounter() {
        counter = Counter(counter.value + 1)
    }

    fun openImageScreen() =
        onOpenImageScreen.send("https://foo.com/image")

    fun openCoroutinesScreen() = onOpenCoroutinesScreen.send()

    fun callApi() {
        launchIO {
            val response = try {
                TodoApi.getTodos.call()
            } catch (e: Exception) {
                e.printStackTrace()
                return@launchIO
            }

            onShowToast.send("${response.body()!!.size}")
        }
    }
}