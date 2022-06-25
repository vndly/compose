package com.mauriciotogneri.composetest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mauriciotogneri.composetest.ui.theme.ComposeTestTheme

class TestComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                Content(listOf("John", "Peter", "Jennifer"))
            }
        }
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit) {
    ComposeTestTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            content()
        }
    }
}

@Composable
fun Content(names: List<String>) {
    var counterState by remember {
        mutableStateOf(0)
    }

    Column {
        for (name in names) {
            Greeting(name = name)
            Divider()
        }
        CounterButton(
            count = counterState,
            updateCount = { newCount: Int ->
                counterState = newCount
                counterState
            }
        )
        if (counterState > 5) {
            Text("I love to count!")
        }
    }
}

@Composable
fun Greeting(name: String) {
    Box(
        contentAlignment = Alignment.Center
    )
    {
        Text(
            text = "Hello, $name!",
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Composable
fun CounterButton(count: Int, updateCount: (Int) -> Int) {
    Button(onClick = { updateCount(count + 1) }) {
        Text("Clicked $count times")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApp {
        Content(listOf("John", "Peter", "Jennifer"))
    }
}