package com.mauriciotogneri.composetest

import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick

object CounterSteps {
    fun `I click on the counter`(rule: ComposeContentTestRule) {
        rule.onNodeWithTag("counterButton").performClick()
    }

    fun `I see the counter as`(rule: ComposeContentTestRule, times: Int) {
        rule.onNodeWithText("Clicked $times times").assertExists()
    }
}