package com.mauriciotogneri.composetest

import com.mauriciotogneri.composetest.base.BaseActivity

class MainActivity : BaseActivity<CounterState, CounterView>() {
    override fun createState(): CounterState = CounterState()

    override fun createView(): CounterView = CounterView(state)
}