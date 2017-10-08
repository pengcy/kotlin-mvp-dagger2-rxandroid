package com.example.kotlinmvpdaggerrxkotlin

import android.os.SystemClock
import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.example.kotlinmvpdaggerrxkotlin.ui.MainActivity
import org.hamcrest.core.StringStartsWith.startsWith
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class MainScreenViewTest {
    val packageName = "com.example.kotlinmvpdaggerrxkotlin"
    val searchString1 = "pengcy"
    var searchString1Result = "Peng"
    val searchString2 = "aaabbbccbbdndb"
    val waitTime :Long = 3000


    @Rule @JvmField
    val mActivityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getTargetContext()
        Assert.assertEquals(packageName, appContext.packageName)
    }

    @Test
    fun successSearch() {
        // Type the search term and press search button
        onView(ViewMatchers.withId(R.id.ed_search_term)).perform(ViewActions.typeText(searchString1), ViewActions.closeSoftKeyboard())
        onView(ViewMatchers.withId(R.id.ed_search_term)).perform(ViewActions.pressImeActionButton())

        SystemClock.sleep(waitTime);
        onView(withId(R.id.tv_result)).check(matches(withText(startsWith(searchString1Result))));
    }

    @Test
    fun failSearch() {
        // Type the search term and press search button
        onView(ViewMatchers.withId(R.id.ed_search_term)).perform(ViewActions.typeText(searchString2), ViewActions.closeSoftKeyboard())
        onView(ViewMatchers.withId(R.id.ed_search_term)).perform(ViewActions.pressImeActionButton())

        SystemClock.sleep(waitTime);
        onView(withId(R.id.tv_result)).check(matches(withText(R.string.not_found)));
    }
}