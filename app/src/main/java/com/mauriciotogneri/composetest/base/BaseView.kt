package com.mauriciotogneri.composetest.base

import androidx.compose.runtime.Composable

abstract class BaseView {
    @Composable
    abstract fun Root()

    fun onCleared() {}
}