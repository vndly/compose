package com.mauriciotogneri.composetest.tests

import com.mauriciotogneri.composetest.R
import com.mauriciotogneri.composetest.base.BaseSteps

object CounterSteps : BaseSteps() {
    fun `I click on the counter`() {
        withTag("counterButton").click()
    }

    fun `I see the counter as`(times: Int) {
        withText(string(R.string.counter_button, times)).exists()
    }

    fun `I click on the image button`() {
        withTag("imageButton").click()
    }

    fun `I see the image screen`() {
        withTag("imageScreen").exists()
    }
}