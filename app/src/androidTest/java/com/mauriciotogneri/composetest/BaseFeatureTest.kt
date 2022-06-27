package com.mauriciotogneri.composetest

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
abstract class BaseFeatureTest(testRule: ComposeContentTestRule) {
    @get:Rule
    val rule: ComposeContentTestRule = testRule

    init {
        BaseSteps.rule = rule
    }

    fun run(steps: () -> Unit) = steps.invoke()

    companion object {
        inline fun <reified A : ComponentActivity> rule(): ComposeContentTestRule =
            createAndroidComposeRule<A>()
    }
}