package com.mauriciotogneri.composetest.screens.coroutines.state

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.mauriciotogneri.composetest.base.BaseState
import kotlinx.coroutines.delay
import kotlin.system.measureTimeMillis

// Scopes:
// CoroutineScope()
// MainScope()
// viewModelScope
// lifecycleScope

// Dispatchers:
// Dispatchers.Default
// Dispatchers.Main
// Dispatchers.IO
class CoroutinesState : BaseState() {
    fun testLaunch() {
        val job = launchDefault {
            println("This is executed before the first delay")
            stall()
            println("This is executed after the first delay")
            println("This is executed before the second delay")
            stall()
            println("This is executed after the second delay")
        }

        println("Job returned by launch(): $job")
    }

    fun testAsync() {
        launchDefault {
            val deferred = asyncDefault {
                stall()
                println("This is executed after the delay")
                42
            }

            println("This is executed after calling async()")

            val result = deferred.await()

            println("This is the result: $result")
        }

        println("This is executed immediately")
    }

    fun testSuspend() {
        launchDefault {
            val text = suspendDefault {
                greetings()
            }
            println(text)
        }
    }

    suspend fun greetings(): String {
        stall()
        return "Hello, world!"
    }

    private suspend fun stall() = delay(2000L)
}

class CoroutinesStateFactory(
    private val lifecycle: ViewModelStoreOwner,
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T = CoroutinesState() as T

    fun get() = ViewModelProvider(lifecycle, this).get(CoroutinesState::class.java)
}
