package com.mauriciotogneri.composetest.common

sealed class LoadingState<out T : Any> {
    object Loading : LoadingState<Nothing>()

    data class Content<out T : Any>(val data: T) : LoadingState<T>()

    data class Error(val exception: Exception) : LoadingState<Nothing>()
}