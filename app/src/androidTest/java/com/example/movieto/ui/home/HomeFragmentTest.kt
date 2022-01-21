package com.example.movieto.ui.home

import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.movieto.R
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class HomeFragmentTest{


    private lateinit var scenario: FragmentScenario<HomeFragment>


    @Before
    fun setUp()
    {
        scenario= launchFragmentInContainer(themeResId = R.style.Theme_Movieto)
    }

    @Test
    fun testFragment_inView() {
        scenario.moveToState(Lifecycle.State.RESUMED)
        onView(withId(R.id.home_fragment)).check(matches(isDisplayed()))
    }
}