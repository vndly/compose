package com.mauriciotogneri.composetest.common

sealed class Result<out T : Any> {
    data class Succes<out T : Any>(val data: T) : Result<T>()

    sealed class Error(val exception: Exception) : Result<Nothing>() {
        class RecoverableError(exception: Exception) : Error(exception)
        class UnrecoverableError(exception: Exception) : Error(exception)
    }

    object InProgress : Result<Nothing>()
}