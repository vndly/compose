package com.mauriciotogneri.composetest.screens.counter.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import com.mauriciotogneri.composetest.R
import com.mauriciotogneri.composetest.base.BaseView
import com.mauriciotogneri.composetest.screens.counter.state.CounterState
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
            ImageScreenButton(
                callback = { state.openImageScreen() }
            )
            CoroutinesButton(
                callback = { state.openCoroutinesScreen() }
            )
            RetrofitButton(
                callback = { state.callApi() }
            )
            JetpackButton(
                callback = { state.openJetpackScreen() }
            )
        }
    }

    @Composable
    fun CounterButton(count: Int, callback: () -> Unit) {
        Button(
            modifier = Modifier.testTag("counterButton"),
            onClick = { callback() }
        ) {
            Text(stringResource(R.string.counter_button_increase, count))
        }
    }

    @Composable
    fun ImageScreenButton(callback: () -> Unit) {
        Button(
            modifier = Modifier.testTag("imageButton"),
            onClick = { callback() }
        ) {
            Text(stringResource(R.string.counter_button_imageScreen))
        }
    }

    @Composable
    fun CoroutinesButton(callback: () -> Unit) {
        Button(
            modifier = Modifier.testTag("imageButton"),
            onClick = { callback() }
        ) {
            Text(stringResource(R.string.counter_button_coroutinesScreen))
        }
    }

    @Composable
    fun RetrofitButton(callback: () -> Unit) {
        Button(
            modifier = Modifier.testTag("retrofitButton"),
            onClick = { callback() }
        ) {
            Text(stringResource(R.string.counter_button_retrofit))
        }
    }

    @Composable
    fun JetpackButton(callback: () -> Unit) {
        Button(
            modifier = Modifier.testTag("jetpackButton"),
            onClick = { callback() }
        ) {
            Text(stringResource(R.string.counter_button_jetpack))
        }
    }
}