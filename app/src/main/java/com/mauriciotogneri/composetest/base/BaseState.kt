package com.mauriciotogneri.composetest.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*

open class BaseState : ViewModel() {
    fun launchDefault(block: suspend CoroutineScope.() -> Unit): Job =
        viewModelScope.launch(Dispatchers.Default, block = block)

    fun launchMain(block: suspend CoroutineScope.() -> Unit): Job =
        viewModelScope.launch(Dispatchers.Main, block = block)

    fun launchIO(block: suspend CoroutineScope.() -> Unit): Job =
        viewModelScope.launch(Dispatchers.IO, block = block)

    fun <T> asyncDefault(block: suspend CoroutineScope.() -> T): Deferred<T> =
        viewModelScope.async(Dispatchers.Default, block = block)

    fun <T> asyncMain(block: suspend CoroutineScope.() -> T): Deferred<T> =
        viewModelScope.async(Dispatchers.Main, block = block)

    fun <T> asyncIO(block: suspend CoroutineScope.() -> T): Deferred<T> =
        viewModelScope.async(Dispatchers.IO, block = block)

    suspend fun <T> suspendDefault(block: suspend CoroutineScope.() -> T) =
        withContext(Dispatchers.Default, block = block)

    suspend fun <T> suspendMain(block: suspend CoroutineScope.() -> T) =
        withContext(Dispatchers.Main, block = block)

    suspend fun <T> suspendIO(block: suspend CoroutineScope.() -> T) =
        withContext(Dispatchers.IO, block = block)
}