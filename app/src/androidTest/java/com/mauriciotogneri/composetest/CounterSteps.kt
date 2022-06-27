package com.mauriciotogneri.composetest

import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick

object CounterSteps {
    lateinit var rule: ComposeContentTestRule

    fun `I click on the counter`() {
        rule.onNodeWithTag("counterButton").performClick()
    }

    fun `I see the counter as`(times: Int) {
        rule.onNodeWithText("Clicked $times times").assertExists()
    }
}