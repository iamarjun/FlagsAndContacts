package com.alwaysbaked.flagsandcontacts.ui

import android.support.test.espresso.Espresso
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.util.Log
import com.alwaysbaked.flagsandcontacts.LoginActivity
import com.alwaysbaked.flagsandcontacts.R.id.*
import com.alwaysbaked.flagsandcontacts.flags.util.ViewHolder
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.util.*

@RunWith(AndroidJUnit4::class)

@LargeTest
class UIFlowTest {
    companion object {
        private const val TAG = "UIFlowTest"
    }

    @get: Rule
    val rule: ActivityTestRule<LoginActivity> = ActivityTestRule(LoginActivity::class.java)

    private val CORRECT_USERNAME = "arjun"
    private val CORRECT_PASSWORD = "12345"

    //generate random number
    private val random = Random()


    @Test
    fun uiFlow() {
        Log.e(TAG, "uiFlow: started.")

        //login
        Espresso.onView(ViewMatchers.withId(etLoginUsername))
                .perform(ViewActions.replaceText(CORRECT_USERNAME))

        Espresso.onView(ViewMatchers.withId(etLoginPassword))
                .perform(ViewActions.replaceText(CORRECT_PASSWORD))

        Thread.sleep(2000)

        Espresso.onView(ViewMatchers.withId(btnLogin))
                .perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withText("Login Successful"))
                .inRoot(ToastMatcher())
                .check(matches(ViewMatchers.withText("Login Successful")))

        Thread.sleep(2000)

        // switch to flag
        Espresso.onView(ViewMatchers.withId(btnFlags))
                .perform(ViewActions.click())

        //load the recyclerview
        Thread.sleep(6000)

        Espresso.onView(ViewMatchers.withId(rvFeed))
                .perform(RecyclerViewActions.actionOnItemAtPosition<ViewHolder>(random.nextInt(10), click()))

        //hold it right there, the flag
        Thread.sleep(2000)

        //Back to Recyclerview -> SwitchActivity
        Espresso.pressBack()
        Espresso.pressBack()

        Thread.sleep(2000)

        // switch to contacts
        Espresso.onView(ViewMatchers.withId(btnContacts))
                .perform(ViewActions.click())

        Thread.sleep(2000)

        //Export the contacts
        Espresso.onView(ViewMatchers.withId(btn_export))
                .perform(ViewActions.click())

        Thread.sleep(2000)
    }

}