package com.mauriciotogneri.composetest

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.mauriciotogneri.composetest.base.BaseView
import com.mauriciotogneri.composetest.ui.theme.ComposeTestTheme

class CounterView(private val state: CounterState) : BaseView() {
    @Composable
    override fun Root() {
        ComposeTestTheme {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colors.background
            ) {
                Content()
            }
        }
    }

    @Composable
    fun Content() {
        Column {
            CounterButton(
                count = state.counter,
                updateCount = { state.increaseCounter() }
            )
        }
    }

    @Composable
    fun CounterButton(count: Int, updateCount: () -> Unit) {
        Button(onClick = { updateCount() }) {
            Text("Clicked $count times")
        }
    }
}