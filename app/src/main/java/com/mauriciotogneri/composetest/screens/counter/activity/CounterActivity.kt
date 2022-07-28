package com.mauriciotogneri.composetest.screens.counter.activity

import android.os.Bundle
import android.widget.Toast
import com.mauriciotogneri.composetest.base.BaseActivity
import com.mauriciotogneri.composetest.screens.coroutines.activity.CoroutinesActivity
import com.mauriciotogneri.composetest.screens.counter.state.CounterState
import com.mauriciotogneri.composetest.screens.counter.view.CounterView
import com.mauriciotogneri.composetest.screens.image.activity.ImageActivity

class CounterActivity : BaseActivity<CounterState, CounterView>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        registerEvent(state.onOpenImageScreen, ::onOpenImageScreen)
        registerEvent(state.onOpenCoroutinesScreen, ::onOpenCoroutinesScreen)
        registerEvent(state.onShowToast, ::showToast)
    }

    override fun createState() = CounterState()

    override fun createView() = CounterView(state)

    private fun onOpenImageScreen(url: String) = startActivity(ImageActivity.intent(url, this))

    private fun onOpenCoroutinesScreen() = startActivity(CoroutinesActivity.intent(this))

    private fun showToast(text: String) = Toast.makeText(this, text, Toast.LENGTH_LONG).show()
}