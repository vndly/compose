package com.mauriciotogneri.composetest.screens.coroutines.state

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.mauriciotogneri.composetest.base.BaseState
import kotlinx.coroutines.*

class CoroutinesState : BaseState() {
    fun test1() {
        GlobalScope.launch(Dispatchers.Main) {
            println("This is executed before the first delay")
            stallForTime()
            println("This is executed after the first delay")
            println("This is executed before the second delay")
            stallForTime()
            println("This is executed after the second delay")
        }

        println("This is executed immediately")
    }

    private suspend fun stallForTime() {
        withContext(Dispatchers.Default) {
            delay(2000L)
        }
    }
}

class CoroutinesStateFactory(
    private val lifecycle: ViewModelStoreOwner,
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T = CoroutinesState() as T

    fun get() = ViewModelProvider(lifecycle, this).get(CoroutinesState::class.java)
}
