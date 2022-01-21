package com.example.movieto

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import junit.framework.TestCase
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest
{

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)//method 1

    @Test
    fun testActivity_inView() {
       // val activityScenario = ActivityScenario.launch(MainActivity::class.java)//method 2


        onView(withId(R.id.main_activity)).check(matches(isDisplayed()))// method 1

        onView(withId(R.id.main_activity))
            .check(matches(ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE))) // method 2
    }

    @Test
    fun testActivity_FragmentContainerView_Displayed() {
        onView(withId(R.id.fragmentContainerView_activity)).check(matches(isDisplayed()))
    }
}