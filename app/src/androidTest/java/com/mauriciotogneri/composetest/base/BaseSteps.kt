package com.mauriciotogneri.composetest.base

import androidx.annotation.StringRes
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.key.KeyEvent
import androidx.compose.ui.semantics.AccessibilityAction
import androidx.compose.ui.semantics.SemanticsPropertyKey
import androidx.compose.ui.test.*
import com.mauriciotogneri.composetest.base.BaseFeatureTest.Companion.rule

open class BaseSteps {
    fun string(@StringRes id: Int, vararg formatArgs: Any) =
        rule.activity.getString(id, *formatArgs)

    // ============================== finders ============================== \\

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

    // ============================== actions ============================== \\

    fun SemanticsNodeInteraction.click() = performClick()

    fun SemanticsNodeInteraction.doubleClick() = performTouchInput { doubleClick() }

    fun SemanticsNodeInteraction.longClick() = performTouchInput { longClick() }

    fun SemanticsNodeInteraction.pinch(
        start0: Offset,
        end0: Offset,
        start1: Offset,
        end1: Offset,
        durationMillis: Long = 400
    ) = performTouchInput { pinch(start0, end0, start1, end1, durationMillis) }

    fun SemanticsNodeInteraction.swipe(
        start: Offset,
        end: Offset,
        durationMillis: Long = 200
    ) = performTouchInput { swipe(start, end, durationMillis) }

    fun SemanticsNodeInteraction.swipeUp() = performTouchInput { swipeUp() }

    fun SemanticsNodeInteraction.swipeDown() = performTouchInput { swipeDown() }

    fun SemanticsNodeInteraction.swipeLeft() = performTouchInput { swipeLeft() }

    fun SemanticsNodeInteraction.swipeRight() = performTouchInput { swipeRight() }

    fun SemanticsNodeInteraction.up(pointerId: Int = 0) = performTouchInput { up(pointerId) }

    fun SemanticsNodeInteraction.down(position: Offset) = performTouchInput { down(position) }

    fun SemanticsNodeInteraction.cancel() = performTouchInput { cancel() }

    fun SemanticsNodeInteraction.move() = performTouchInput { move() }

    fun SemanticsNodeInteraction.moveTo(position: Offset) = performTouchInput { moveTo(position) }

    fun SemanticsNodeInteraction.moveBy(delta: Offset) = performTouchInput { moveBy(delta) }

    fun SemanticsNodeInteraction.touch(
        block: TouchInjectionScope.() -> Unit
    ) = performTouchInput(block)

    fun SemanticsNodeInteraction.multiModal(
        block: MultiModalInjectionScope.() -> Unit
    ) = performMultiModalInput(block)

    fun SemanticsNodeInteraction.scrollTo() = performScrollTo()

    fun SemanticsNodeInteraction.semanticsAction(
        key: SemanticsPropertyKey<AccessibilityAction<() -> Boolean>>
    ) = performSemanticsAction(key)

    fun SemanticsNodeInteraction.keyPress(keyEvent: KeyEvent) = performKeyPress(keyEvent)

    fun SemanticsNodeInteraction.imeAction() = performImeAction()

    fun SemanticsNodeInteraction.textClearance() = performTextClearance()

    fun SemanticsNodeInteraction.textInput(text: String) = performTextInput(text)

    fun SemanticsNodeInteraction.textReplacement(text: String) = performTextReplacement(text)

    // ============================= assertions ============================ \\

    fun SemanticsNodeInteraction.exists(errorMessageOnFail: String? = null) =
        assertExists(errorMessageOnFail)
}