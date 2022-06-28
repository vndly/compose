package com.mauriciotogneri.composetest.tests

import androidx.compose.ui.test.performClick
import com.mauriciotogneri.composetest.base.BaseSteps

object CounterSteps : BaseSteps() {
    fun `I click on the counter`() {
        withTag("counterButton").performClick()
    }

    fun `I see the counter as`(times: Int) {
        withText("Clicked $times times").assertExists()
    }

    fun `I click on the image button`() {
        withTag("imageButton").performClick()
    }

    fun `I see the image screen`() {
        withTag("imageScreen").assertExists()
    }
}