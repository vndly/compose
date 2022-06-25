package com.mauriciotogneri.composetest

import com.mauriciotogneri.composetest.base.BaseState

class CounterState : BaseState() {
    var counter : Int = 0

    fun increaseCounter() {
        counter++
    }
}