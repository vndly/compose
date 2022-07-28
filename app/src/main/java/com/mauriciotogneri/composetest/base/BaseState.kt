package com.mauriciotogneri.composetest.base

import kotlinx.coroutines.*

open class BaseState {
    fun onCleared() {}

    fun defaultLaunch(block: suspend CoroutineScope.() -> Unit): Job =
        CoroutineScope(Dispatchers.Default).launch(Dispatchers.Default, block = block)

    fun mainLaunch(block: suspend CoroutineScope.() -> Unit): Job =
        CoroutineScope(Dispatchers.Main).launch(Dispatchers.Main, block = block)

    fun ioLaunch(block: suspend CoroutineScope.() -> Unit): Job =
        CoroutineScope(Dispatchers.IO).launch(Dispatchers.IO, block = block)

    fun <T> defaultAsync(block: suspend CoroutineScope.() -> T): Deferred<T> =
        CoroutineScope(Dispatchers.Default).async(Dispatchers.Default, block = block)

    fun <T> mainAsync(block: suspend CoroutineScope.() -> T): Deferred<T> =
        CoroutineScope(Dispatchers.Main).async(Dispatchers.Main, block = block)

    fun <T> ioAsync(block: suspend CoroutineScope.() -> T): Deferred<T> =
        CoroutineScope(Dispatchers.IO).async(Dispatchers.IO, block = block)

    suspend fun <T> defaultAwait(block: suspend CoroutineScope.() -> T): T =
        defaultAsync(block).await()

    suspend fun <T> mainAwait(block: suspend CoroutineScope.() -> T): T = mainAsync(block).await()

    suspend fun <T> ioAwait(block: suspend CoroutineScope.() -> T): T = ioAsync(block).await()

    suspend fun <T> defaultSuspend(block: suspend CoroutineScope.() -> T) =
        withContext(Dispatchers.Default, block = block)

    suspend fun <T> mainSuspend(block: suspend CoroutineScope.() -> T) =
        withContext(Dispatchers.Main, block = block)

    suspend fun <T> ioSuspend(block: suspend CoroutineScope.() -> T) =
        withContext(Dispatchers.IO, block = block)
}