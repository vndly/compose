package com.mauriciotogneri.composetest.screens.coroutines.state

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.viewModelScope
import com.mauriciotogneri.composetest.base.BaseState
import kotlinx.coroutines.*

// Scopes:
// MainScope()
// lifecycleScope

// Dispatchers:
// Dispatchers.Default
// Dispatchers.Main
// Dispatchers.IO
class CoroutinesState : BaseState() {
    fun test1() {
        val job = viewModelScope.launch(Dispatchers.Main) {
            println("This is executed before the first delay")
            stallForTime()
            println("This is executed after the first delay")
            println("This is executed before the second delay")
            stallForTime()
            println("This is executed after the second delay")
        }

        println("Job returned by launch(): $job")
    }

    fun test2() {
        viewModelScope.launch(Dispatchers.Main) {
            val deferred = viewModelScope.async(Dispatchers.Default) {
                delay(2000L)
                println("This is executed after the delay")
                42
            }

            println("This is executed after calling async()")

            val result = deferred.await()

            println("This is the result: $result")
        }

        println("This is executed immediately")
    }

    fun test3() {
        runBlocking {
            val text = async { greetings() }
            println(text.await())
        }
    }

    private suspend fun greetings(): String {
        delay(2000L)

        return "Hello, world!"
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
