package com.mauriciotogneri.composetest.counter.state

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.mauriciotogneri.composetest.base.BaseState
import com.mauriciotogneri.composetest.counter.model.Counter

class CounterState : BaseState() {
    var counter by mutableStateOf(Counter())

    fun increaseCounter() {
        counter = Counter(counter.value + 1)
    }
}
