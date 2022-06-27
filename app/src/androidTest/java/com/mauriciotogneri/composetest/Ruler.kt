package com.mauriciotogneri.composetest

import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.mauriciotogneri.composetest.counter.activity.CounterActivity

object Ruler {
    val rule: ComposeContentTestRule = createAndroidComposeRule<CounterActivity>()
}