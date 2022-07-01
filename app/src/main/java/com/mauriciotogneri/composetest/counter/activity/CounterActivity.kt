package com.mauriciotogneri.composetest.counter.activity

import android.os.Bundle
import com.mauriciotogneri.composetest.base.BaseActivity
import com.mauriciotogneri.composetest.counter.state.CounterState
import com.mauriciotogneri.composetest.counter.state.CounterStateFactory
import com.mauriciotogneri.composetest.counter.view.CounterView
import com.mauriciotogneri.composetest.image.activity.ImageActivity

class CounterActivity : BaseActivity<CounterState, CounterView>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        state.onOpenScreen.observe(this) { url ->
            startActivity(ImageActivity.intent(url, this))
        }
    }

    override fun createState() = CounterStateFactory(this).get()

    override fun createView() = CounterView(state)

    fun onOpenNewScreen(url: String) = startActivity(ImageActivity.intent(url, this))
}