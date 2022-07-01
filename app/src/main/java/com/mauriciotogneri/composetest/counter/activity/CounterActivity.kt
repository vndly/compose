package com.mauriciotogneri.composetest.counter.activity

import com.mauriciotogneri.composetest.base.BaseActivity
import com.mauriciotogneri.composetest.counter.state.CounterState
import com.mauriciotogneri.composetest.counter.state.CounterStateCallback
import com.mauriciotogneri.composetest.counter.state.CounterStateFactory
import com.mauriciotogneri.composetest.counter.view.CounterView
import com.mauriciotogneri.composetest.image.activity.ImageActivity

class CounterActivity : BaseActivity<CounterState, CounterView>(), CounterStateCallback {
    override fun createState() = CounterStateFactory(this, this).get()

    override fun createView() = CounterView(state)

    override fun onOpenNewScreen(url: String) = startActivity(ImageActivity.intent(url, this))
}