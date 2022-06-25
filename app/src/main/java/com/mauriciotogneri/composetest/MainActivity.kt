package com.mauriciotogneri.composetest

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.mauriciotogneri.composetest.base.BaseActivity

class MainActivity : BaseActivity<CounterState, CounterView>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        state = CounterState()
        view = CounterView(state)

        setContent {
            view.Root()
        }
    }

    @Composable
    @Preview(showBackground = true)
    fun DefaultPreview() = CounterView(state).Root()
}