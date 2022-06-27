package com.mauriciotogneri.composetest.image.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import com.mauriciotogneri.composetest.base.BaseView
import com.mauriciotogneri.composetest.image.state.ImageState
import com.mauriciotogneri.composetest.ui.theme.ComposeTestTheme

class ImageView(private val state: ImageState) : BaseView() {
    @Composable
    override fun Root() {
        ComposeTestTheme {
            Surface(
                modifier = Modifier.fillMaxSize().testTag("imageScreen"),
                color = MaterialTheme.colors.background
            ) {
                Content()
            }
        }
    }

    @Composable
    fun Content() {
        Column {
            Text(text = state.url)
        }
    }

}