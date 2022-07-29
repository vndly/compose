package com.mauriciotogneri.composetest.screens.counter.state

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.mauriciotogneri.composetest.api.TodoApi
import com.mauriciotogneri.composetest.base.BaseState
import com.mauriciotogneri.composetest.common.Coroutines.ioLaunch
import com.mauriciotogneri.composetest.common.Coroutines.mainLaunch
import com.mauriciotogneri.composetest.repository.Repository
import com.mauriciotogneri.composetest.screens.counter.model.Counter

class CounterState constructor(
    private val observer: CounterStateObserver,
    private val repository: Repository,
) : BaseState() {
    var counter by mutableStateOf(Counter())

    fun increaseCounter() {
        counter = Counter(counter.value + 1)
    }

    fun openImageScreen() =
        observer.openImageScreen("https://foo.com/image/${repository.testMethod()}")

    fun openCoroutinesScreen() = observer.openCoroutinesScreen()

    fun openJetpackScreen() = observer.openJetpackScreen("It works!")

    fun callApi() {
        ioLaunch {
            val response = try {
                TodoApi.getTodos.call()
            } catch (e: Exception) {
                e.printStackTrace()
                return@ioLaunch
            }

            mainLaunch {
                observer.showToast("${response.body()!!.size}")
            }
        }
    }
}

interface CounterStateObserver {
    fun openImageScreen(url: String)

    fun openCoroutinesScreen()

    fun openJetpackScreen(param: String)

    fun showToast(text: String)
}