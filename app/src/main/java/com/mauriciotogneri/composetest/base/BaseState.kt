package com.mauriciotogneri.composetest.base

import androidx.lifecycle.ViewModel

open class BaseState: ViewModel() {
    fun onDestroy() {}
}