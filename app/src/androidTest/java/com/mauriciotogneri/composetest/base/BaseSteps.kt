package com.mauriciotogneri.composetest.base

import androidx.compose.ui.test.SemanticsNodeInteraction
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import com.mauriciotogneri.composetest.base.BaseFeatureTest.Companion.rule

open class BaseSteps {
    fun withTag(
        testTag: String,
        useUnmergedTree: Boolean = false
    ): SemanticsNodeInteraction = rule.onNodeWithTag(
        testTag,
        useUnmergedTree,
    )

    fun withText(
        text: String,
        substring: Boolean = false,
        ignoreCase: Boolean = false,
        useUnmergedTree: Boolean = false
    ): SemanticsNodeInteraction = rule.onNodeWithText(
        text,
        substring,
        ignoreCase,
        useUnmergedTree,
    )
}