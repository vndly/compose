package com.mauriciotogneri.composetest.counter.activity

import com.mauriciotogneri.composetest.base.BaseActivity
import com.mauriciotogneri.composetest.context.AndroidContext
import com.mauriciotogneri.composetest.counter.state.CounterState
import com.mauriciotogneri.composetest.counter.view.CounterView

class CounterActivity : BaseActivity<CounterState, CounterView>() {
    override fun createState(): CounterState = CounterState(androidContext())

    override fun createView(): CounterView = CounterView(state)
}