package com.mauriciotogneri.composetest.base

import androidx.compose.runtime.Composable

abstract class BaseView<T>(val state: T) where T : BaseState {
    @Composable
    abstract fun Root()
}