package com.mauriciotogneri.composetest

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.junit4.AndroidComposeTestRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.rules.ActivityScenarioRule

class CounterSteps<A : ComponentActivity>(private val rule: AndroidComposeTestRule<ActivityScenarioRule<A>, A>) {
    fun `I click on the counter`() {
        rule.onNodeWithTag("counterButton").performClick()
    }

    fun `I see the counter as`(times: Int) {
        rule.onNodeWithText("Clicked $times times").assertExists()
    }
}