package com.mauriciotogneri.composetest.base

import androidx.annotation.StringRes
import androidx.compose.ui.test.*
import com.mauriciotogneri.composetest.base.BaseFeatureTest.Companion.rule

open class BaseSteps {
    fun string(@StringRes id: Int, vararg formatArgs: Any) =
        rule.activity.getString(id, *formatArgs)

    fun root(useUnmergedTree: Boolean = false) = rule.onRoot(useUnmergedTree)

    fun node(
        matcher: SemanticsMatcher,
        useUnmergedTree: Boolean
    ) = rule.onNode(
        matcher,
        useUnmergedTree,
    )

    fun withTag(
        testTag: String,
        useUnmergedTree: Boolean = false
    ) = rule.onNodeWithTag(
        testTag,
        useUnmergedTree,
    )

    fun withText(
        text: String,
        substring: Boolean = false,
        ignoreCase: Boolean = false,
        useUnmergedTree: Boolean = false
    ) = rule.onNodeWithText(
        text,
        substring,
        ignoreCase,
        useUnmergedTree,
    )

    fun withDescription(
        label: String,
        substring: Boolean = false,
        ignoreCase: Boolean = false,
        useUnmergedTree: Boolean = false
    ) = rule.onNodeWithContentDescription(
        label,
        substring,
        ignoreCase,
        useUnmergedTree,
    )

    fun allNodes(
        matcher: SemanticsMatcher,
        useUnmergedTree: Boolean
    ) = rule.onAllNodes(
        matcher,
        useUnmergedTree,
    )

    fun nodesWithTag(
        testTag: String,
        useUnmergedTree: Boolean = false
    ) = rule.onAllNodesWithTag(
        testTag,
        useUnmergedTree,
    )

    fun nodesWithText(
        text: String,
        substring: Boolean = false,
        ignoreCase: Boolean = false,
        useUnmergedTree: Boolean = false
    ) = rule.onAllNodesWithText(
        text,
        substring,
        ignoreCase,
        useUnmergedTree,
    )

    fun nodesWithDescription(
        label: String,
        substring: Boolean = false,
        ignoreCase: Boolean = false,
        useUnmergedTree: Boolean = false
    ) = rule.onAllNodesWithContentDescription(
        label,
        substring,
        ignoreCase,
        useUnmergedTree,
    )

    fun SemanticsNodeInteraction.exists(errorMessageOnFail: String? = null) =
        assertExists(errorMessageOnFail)

    fun SemanticsNodeInteraction.click() = performClick()
}