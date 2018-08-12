package com.alwaysbaked.flagsandcontacts.ui

import android.support.test.espresso.Root
import android.view.WindowManager
import org.hamcrest.Description
import org.hamcrest.TypeSafeMatcher

class ToastMatcher : TypeSafeMatcher<Root>() {
    override fun matchesSafely(item: Root): Boolean {
        val type = item.windowLayoutParams.get().type
        if (type == WindowManager.LayoutParams.TYPE_TOAST) {
            val windowToken = item.decorView.windowToken
            val appToken = item.decorView.applicationWindowToken
            return windowToken === appToken
        }
        return false
    }

    override fun describeTo(description: Description) {
        description.appendText("is toast")

    }
}
