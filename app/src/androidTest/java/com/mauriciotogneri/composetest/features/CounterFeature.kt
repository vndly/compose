package com.mauriciotogneri.composetest.features

import com.mauriciotogneri.composetest.base.feature
import com.mauriciotogneri.composetest.tests.CounterSteps.`I click on the counter`
import com.mauriciotogneri.composetest.tests.CounterSteps.`I click on the image button`
import com.mauriciotogneri.composetest.tests.CounterSteps.`I see the counter as`
import com.mauriciotogneri.composetest.tests.CounterSteps.`I see the image screen`

val CounterFeature = feature {
    scenario {
        `I see the counter as`(0)
    }
    scenario {
        `I click on the counter`()
        `I see the counter as`(1)
    }
    scenario {
        `I click on the counter`()
        `I click on the counter`()
        `I see the counter as`(2)
    }
    scenario {
        `I click on the image button`()
        `I see the image screen`()
    }
}