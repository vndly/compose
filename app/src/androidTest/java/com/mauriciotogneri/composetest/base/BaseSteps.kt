package com.mauriciotogneri.composetest.base

import android.app.Instrumentation
import android.os.Environment
import androidx.annotation.StringRes
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.key.KeyEvent
import androidx.compose.ui.semantics.AccessibilityAction
import androidx.compose.ui.semantics.ProgressBarRangeInfo
import androidx.compose.ui.semantics.SemanticsPropertyKey
import androidx.compose.ui.test.*
import androidx.compose.ui.unit.Dp
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.UiDevice
import com.mauriciotogneri.composetest.base.BaseFeatureTest.Companion.rule
import java.io.File
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

open class BaseSteps {
    fun string(@StringRes id: Int, vararg formatArgs: Any) =
        rule.activity.getString(id, *formatArgs)

    fun screenshot(fileName: String = screenshotName()): Boolean {
        val file = File(
            Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),
            fileName
        )
        val instrumentation: Instrumentation = InstrumentationRegistry.getInstrumentation()

        return UiDevice.getInstance(instrumentation).takeScreenshot(file)
    }

    private fun screenshotName(): String {
        val formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH.mm.ss.SSS")
        val date = LocalDateTime.now()

        return formatter.format(date) + ".png"
    }

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

    fun SemanticsNodeInteraction.doesNotExist() = assertDoesNotExist()

    fun SemanticsNodeInteraction.contentDescriptionContains(
        value: String,
        substring: Boolean = false,
        ignoreCase: Boolean = false
    ) = assertContentDescriptionContains(value, substring, ignoreCase)

    fun SemanticsNodeInteraction.contentDescriptionContains(
        value: String,
    ) = assertContentDescriptionEquals(value)

    fun SemanticsNodeInteraction.isDisplayed() = assertIsDisplayed()

    fun SemanticsNodeInteraction.isNotDisplayed() = assertIsNotDisplayed()

    fun SemanticsNodeInteraction.isEnabled() = assertIsEnabled()

    fun SemanticsNodeInteraction.isNotEnabled() = assertIsNotEnabled()

    fun SemanticsNodeInteraction.isSelected() = assertIsSelected()

    fun SemanticsNodeInteraction.isNotSelected() = assertIsNotSelected()

    fun SemanticsNodeInteraction.isFocused() = assertIsFocused()

    fun SemanticsNodeInteraction.isNotFocused() = assertIsNotFocused()

    fun SemanticsNodeInteraction.isOn() = assertIsOn()

    fun SemanticsNodeInteraction.isOff() = assertIsOff()

    fun SemanticsNodeInteraction.isToggleable() = assertIsToggleable()

    fun SemanticsNodeInteraction.isSelectable() = assertIsSelectable()

    fun SemanticsNodeInteraction.textEquals(
        vararg values: String,
        includeEditableText: Boolean = true
    ) = assertTextEquals(*values, includeEditableText = includeEditableText)

    fun SemanticsNodeInteraction.textContains(
        value: String,
        substring: Boolean = false,
        ignoreCase: Boolean = false
    ) = assertTextContains(value, substring, ignoreCase)

    fun SemanticsNodeInteraction.valueEquals(value: String) = assertValueEquals(value)

    fun SemanticsNodeInteraction.rangeInfoEquals(value: ProgressBarRangeInfo) =
        assertRangeInfoEquals(value)

    fun SemanticsNodeInteraction.hasClickAction() = assertHasClickAction()

    fun SemanticsNodeInteraction.hasNoClickAction() = assertHasNoClickAction()

    fun SemanticsNodeInteraction.widthIsEqualTo(expectedWidth: Dp) =
        assertWidthIsEqualTo(expectedWidth)

    fun SemanticsNodeInteraction.heightIsEqualTo(expectedHeight: Dp) =
        assertHeightIsEqualTo(expectedHeight)

    fun SemanticsNodeInteraction.widthIsAtLeast(expectedMinWidth: Dp) =
        assertWidthIsAtLeast(expectedMinWidth)

    fun SemanticsNodeInteraction.heightIsAtLeast(expectedMinHeight: Dp) =
        assertHeightIsAtLeast(expectedMinHeight)
}