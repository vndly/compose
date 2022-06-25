package com.mauriciotogneri.composetest

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.mauriciotogneri.composetest.base.BaseState

class CounterState : BaseState() {
    var counter by mutableStateOf(1)

    fun increaseCounter() {
        counter++
    }
}