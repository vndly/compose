package com.mauriciotogneri.composetest.screens.coroutines.state

import com.mauriciotogneri.composetest.base.BaseState
import kotlinx.coroutines.delay

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
        val job = defaultLaunch {
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
        defaultLaunch {
            val deferred = defaultAsync {
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
        defaultLaunch {
            val text = defaultSuspend {
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