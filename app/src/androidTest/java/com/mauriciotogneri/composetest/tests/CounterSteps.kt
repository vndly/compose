package com.mauriciotogneri.composetest.tests

import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.mauriciotogneri.composetest.base.BaseSteps.rule

object CounterSteps {
    fun `I click on the counter`() {
        rule.onNodeWithTag("counterButton").performClick()
    }

    fun `I see the counter as`(times: Int) {
        rule.onNodeWithText("Clicked $times times").assertExists()
    }

    fun `I click on the image button`() {
        rule.onNodeWithTag("imageButton").performClick()
    }

    fun `I see the image screen`() {
        rule.onNodeWithTag("imageScreen").assertExists()
    }
}