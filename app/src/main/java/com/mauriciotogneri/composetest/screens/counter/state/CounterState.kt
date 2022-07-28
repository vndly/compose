package com.mauriciotogneri.composetest.screens.counter.state

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.mauriciotogneri.composetest.api.TodoApi
import com.mauriciotogneri.composetest.base.BaseState
import com.mauriciotogneri.composetest.common.EmptyEvent
import com.mauriciotogneri.composetest.common.Event
import com.mauriciotogneri.composetest.di.Repository
import com.mauriciotogneri.composetest.screens.counter.model.Counter
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

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

class CounterStateFactory(
    private val lifecycle: ViewModelStoreOwner,
) {
    fun get() = ViewModelProvider(lifecycle)[CounterState::class.java]
}