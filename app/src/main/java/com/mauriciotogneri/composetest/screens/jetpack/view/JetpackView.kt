package com.mauriciotogneri.composetest.screens.jetpack.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import com.mauriciotogneri.composetest.screens.jetpack.state.JetpackViewModel
import com.mauriciotogneri.composetest.ui.theme.ComposeTestTheme
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun JetpackView(viewModel: JetpackViewModel = hiltViewModel()) {
    ComposeTestTheme {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .testTag("jetpackScreen"),
            color = MaterialTheme.colors.background
        ) {
            Content(viewModel.param)
        }
    }
}

@Composable
fun Content(param: String) {
    Column {
        Text(text = param)
    }
}