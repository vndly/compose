package com.mauriciotogneri.composetest.screens.counter.activity

import android.widget.Toast
import com.mauriciotogneri.composetest.base.BaseActivity
import com.mauriciotogneri.composetest.screens.coroutines.activity.CoroutinesActivity
import com.mauriciotogneri.composetest.screens.counter.state.CounterState
import com.mauriciotogneri.composetest.screens.counter.state.CounterStateObserver
import com.mauriciotogneri.composetest.screens.counter.view.CounterView
import com.mauriciotogneri.composetest.screens.image.activity.ImageActivity

class CounterActivity : BaseActivity<CounterState, CounterView>(), CounterStateObserver {

    override fun createState() = CounterState(this)

    override fun createView() = CounterView(state)

    override fun openImageScreen(url: String) = startActivity(ImageActivity.intent(url, this))

    override fun openCoroutinesScreen() = startActivity(CoroutinesActivity.intent(this))

    override fun showToast(text: String) = Toast.makeText(this, text, Toast.LENGTH_LONG).show()
}