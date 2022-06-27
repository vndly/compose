package com.mauriciotogneri.composetest

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.junit4.AndroidComposeTestRule
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
abstract class BaseInstrumentedTest<A : ComponentActivity> {
    @get:Rule
    val compose: AndroidComposeTestRule<ActivityScenarioRule<A>, A> by lazy { rule() }

    abstract fun rule() : AndroidComposeTestRule<ActivityScenarioRule<A>, A>
}