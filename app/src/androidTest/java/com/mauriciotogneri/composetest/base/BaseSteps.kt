package com.mauriciotogneri.composetest.base

import androidx.annotation.StringRes
import androidx.compose.ui.test.SemanticsNodeInteraction
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.mauriciotogneri.composetest.base.BaseFeatureTest.Companion.currentRule
import com.mauriciotogneri.composetest.base.BaseFeatureTest.Companion.rule

open class BaseSteps {
    fun string(@StringRes id: Int, vararg formatArgs: Any): String =
        rule().activity.getString(id, *formatArgs)

    fun withTag(
        testTag: String,
        useUnmergedTree: Boolean = false
    ): SemanticsNodeInteraction = rule().onNodeWithTag(
        testTag,
        useUnmergedTree,
    )

    fun withText(
        text: String,
        substring: Boolean = false,
        ignoreCase: Boolean = false,
        useUnmergedTree: Boolean = false
    ): SemanticsNodeInteraction = rule().onNodeWithText(
        text,
        substring,
        ignoreCase,
        useUnmergedTree,
    )

    fun SemanticsNodeInteraction.exists(errorMessageOnFail: String? = null) =
        assertExists(errorMessageOnFail)

    fun SemanticsNodeInteraction.click() = performClick()
}