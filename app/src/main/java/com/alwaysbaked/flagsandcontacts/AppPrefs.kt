package com.alwaysbaked.flagsandcontacts

import android.content.Context
import android.content.SharedPreferences

class AppPrefs(context: Context) {

    val PREF_NAME = "User"

    private val prefs: SharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

    fun getUsername(key: String): String {
        return prefs.getString(key, "empty")
    }

    fun getPassword(key: String): String {
        return prefs.getString(key, "empty")
    }

    fun setUsername(username: String) {
        val editor = prefs.edit()
        editor.putString(username, username)
        editor.apply()
    }

    fun setPassword(password: String) {
        val editor = prefs.edit()
        editor.putString(password, password)
        editor.apply()
    }
}