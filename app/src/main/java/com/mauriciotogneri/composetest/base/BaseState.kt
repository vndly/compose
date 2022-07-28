package com.mauriciotogneri.composetest.base

import kotlinx.coroutines.*

open class BaseState {
    fun launchDefault(block: suspend CoroutineScope.() -> Unit): Job =
        CoroutineScope(Dispatchers.Default).launch(Dispatchers.Default, block = block)

    fun launchMain(block: suspend CoroutineScope.() -> Unit): Job =
        CoroutineScope(Dispatchers.Main).launch(Dispatchers.Main, block = block)

    fun launchIO(block: suspend CoroutineScope.() -> Unit): Job =
        CoroutineScope(Dispatchers.IO).launch(Dispatchers.IO, block = block)

    fun <T> asyncDefault(block: suspend CoroutineScope.() -> T): Deferred<T> =
        CoroutineScope(Dispatchers.Default).async(Dispatchers.Default, block = block)

    fun <T> asyncMain(block: suspend CoroutineScope.() -> T): Deferred<T> =
        CoroutineScope(Dispatchers.Main).async(Dispatchers.Main, block = block)

    fun <T> asyncIO(block: suspend CoroutineScope.() -> T): Deferred<T> =
        CoroutineScope(Dispatchers.IO).async(Dispatchers.IO, block = block)

    suspend fun <T> awaitDefault(block: suspend CoroutineScope.() -> T): T =
        asyncDefault(block).await()

    suspend fun <T> awaitMain(block: suspend CoroutineScope.() -> T): T = asyncMain(block).await()

    suspend fun <T> awaitIO(block: suspend CoroutineScope.() -> T): T = asyncIO(block).await()

    suspend fun <T> suspendDefault(block: suspend CoroutineScope.() -> T) =
        withContext(Dispatchers.Default, block = block)

    suspend fun <T> suspendMain(block: suspend CoroutineScope.() -> T) =
        withContext(Dispatchers.Main, block = block)

    suspend fun <T> suspendIO(block: suspend CoroutineScope.() -> T) =
        withContext(Dispatchers.IO, block = block)
}