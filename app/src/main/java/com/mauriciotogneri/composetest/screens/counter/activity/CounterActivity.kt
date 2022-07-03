package com.mauriciotogneri.composetest.screens.counter.activity

import android.os.Bundle
import com.mauriciotogneri.composetest.base.BaseActivity
import com.mauriciotogneri.composetest.screens.coroutines.activity.CoroutinesActivity
import com.mauriciotogneri.composetest.screens.counter.state.CounterState
import com.mauriciotogneri.composetest.screens.counter.state.CounterStateFactory
import com.mauriciotogneri.composetest.screens.counter.view.CounterView
import com.mauriciotogneri.composetest.screens.image.activity.ImageActivity

class CounterActivity : BaseActivity<CounterState, CounterView>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        state.onOpenImageScreen.observe(this, ::onOpenImageScreen)
        state.onOpenCoroutinesScreen.observe(this, ::onOpenCoroutinesScreen)
    }

    override fun createState() = CounterStateFactory(this).get()

    override fun createView() = CounterView(state)

    private fun onOpenImageScreen(url: String) = startActivity(ImageActivity.intent(url, this))

    private fun onOpenCoroutinesScreen(nothing: Nothing?) =
        startActivity(CoroutinesActivity.intent(this))
}