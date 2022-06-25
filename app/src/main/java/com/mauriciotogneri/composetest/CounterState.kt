package com.mauriciotogneri.composetest

import android.app.Activity
import com.mauriciotogneri.composetest.base.BaseState

class CounterState(activity: Activity) : BaseState(activity) {
    var counter : Int = 0

    fun increaseCounter() {
        counter++
    }
}