package com.mauriciotogneri.composetest.counter.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.mauriciotogneri.composetest.R
import com.mauriciotogneri.composetest.base.BaseView
import com.mauriciotogneri.composetest.counter.state.CounterState
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
                count = state.counter.value,
                callback = { state.increaseCounter() }
            )
            NewScreenButton(
                callback = { state.openNewScreen() }
            )
        }
    }

    @Composable
    fun CounterButton(count: Int, callback: () -> Unit) {
        Button(
            onClick = { callback() }) {
            Text(stringResource(R.string.counter_button, count))
        }
    }

    @Composable
    fun NewScreenButton(callback: () -> Unit) {
        Button(
            onClick = { callback() }) {
            Text(stringResource(R.string.image_button))
        }
    }
}