package com.mauriciotogneri.composetest.image.activity

import com.mauriciotogneri.composetest.base.BaseActivity
import com.mauriciotogneri.composetest.base.ScreenDef
import com.mauriciotogneri.composetest.counter.state.CounterState
import com.mauriciotogneri.composetest.counter.view.CounterView

class ImageActivity : BaseActivity<CounterState, CounterView>() {
    companion object {
        fun def(url: String): ScreenDef<ImageActivity> = ScreenDef(ImageActivity::class.java)
    }

    override fun createState(): CounterState = CounterState(androidContext())

    override fun createView(): CounterView = CounterView(state)
}