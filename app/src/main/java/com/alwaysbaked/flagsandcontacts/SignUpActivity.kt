package com.alwaysbaked.flagsandcontacts

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {
    companion object {
        private const val TAG = "SignUpActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        Log.d(TAG, "onCreate: started")

        val myPref = AppPrefs(this)

        btnSignUp.setOnClickListener {
            val username = etSignUpUsername.text.toString()
            val password = etSignUpPassword.text.toString()

            if (username.isEmpty() || password.isEmpty())
                Toast.makeText(this, "Username or Password cannot be empty", Toast.LENGTH_SHORT).show()
            else {

                myPref.setUsername(username)
                myPref.setPassword(password)

                Toast.makeText(this, "Sign Up Successful", Toast.LENGTH_SHORT).show()

                switchToLoginActivity()
            }

        }

        tvLoginLink.setOnClickListener {
            switchToLoginActivity()

        }

    }

    private fun switchToLoginActivity() {
        Log.d(TAG, "switchToLoginActivity: started")
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)

    }
}
