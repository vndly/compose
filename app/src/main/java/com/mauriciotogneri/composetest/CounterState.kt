package com.mauriciotogneri.composetest

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.mauriciotogneri.composetest.base.BaseState

class CounterState : BaseState() {
    var counter by mutableStateOf(Counter())

    fun increaseCounter() {
        counter = Counter(counter.value + 1)
    }
}

data class Counter(var value: Int = 0)
