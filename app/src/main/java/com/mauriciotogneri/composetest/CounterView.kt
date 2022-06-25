package com.mauriciotogneri.composetest

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.mauriciotogneri.composetest.base.BaseView
import com.mauriciotogneri.composetest.ui.theme.ComposeTestTheme

class CounterView(state: CounterState) : BaseView<CounterState>(state) {
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
        var counterState by remember {
            mutableStateOf(0)
        }

        Column {
            CounterButton(
                count = counterState,
                updateCount = { newCount: Int ->
                    counterState = newCount
                    counterState
                }
            )
        }
    }

    @Composable
    fun CounterButton(count: Int, updateCount: (Int) -> Int) {
        Button(onClick = { updateCount(count + 1) }) {
            Text("Clicked $count times")
        }
    }
}