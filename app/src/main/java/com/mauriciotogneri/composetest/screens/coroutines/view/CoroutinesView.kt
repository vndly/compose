package com.mauriciotogneri.composetest.screens.coroutines.view

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.mauriciotogneri.composetest.R
import com.mauriciotogneri.composetest.base.BaseView
import com.mauriciotogneri.composetest.screens.coroutines.state.CoroutinesState
import com.mauriciotogneri.composetest.ui.theme.ComposeTestTheme

class CoroutinesView(private val state: CoroutinesState) : BaseView() {
    @Composable
    override fun Root() {
        ComposeTestTheme {
            Surface(
                color = MaterialTheme.colors.background
            ) {
                Content()
            }
        }
    }

    @Composable
    fun Content() {
        Column {
            TestButton(
                textResId = R.string.coroutines_button_testLaunch,
                callback = { state.testLaunch() }
            )
            TestButton(
                textResId = R.string.coroutines_button_testAsync,
                callback = { state.testAsync() }
            )
            TestButton(
                textResId = R.string.coroutines_button_testSuspend,
                callback = { state.testSuspend() }
            )
        }
    }

    @Composable
    fun TestButton(textResId: Int, callback: () -> Unit) {
        Button(
            onClick = { callback() }
        ) {
            Text(stringResource(textResId))
        }
    }
}