package com.alwaysbaked.flagsandcontacts

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    companion object {
        private const val TAG = "LoginActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        Log.d(TAG, "onCreate: started")

        val myPref = AppPrefs(this)



        btnLogin.setOnClickListener {
            val username: String = etLoginUsername.text.toString()
            val password: String = etLoginPassword.text.toString()

            val prefUsername: String = myPref.getUsername(username)
            val prefPassword: String = myPref.getPassword(password)

            if (!prefUsername.equals(username) && !prefPassword.equals(password)) {
                if (username.isEmpty() || password.isEmpty())
                    Toast.makeText(this, "Username or Password cannot be empty", Toast.LENGTH_SHORT).show()

                else
                    Toast.makeText(this, "Please Sign Up First", Toast.LENGTH_SHORT).show()

            }

            else if (!prefUsername.equals(username) || !prefPassword.equals(password))
                Toast.makeText(this, "Wrong Username or Password", Toast.LENGTH_SHORT).show()

            else if (prefUsername.equals(username) && prefPassword.equals(password)) {
                Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
                switchToSwitchActivity()
            }
        }

        tvSignUpLink.setOnClickListener {
            switchToSignUpActivity()
        }

    }

    private fun switchToSignUpActivity() {
        Log.d(TAG, "switchToSignUpActivity: started")
        val intent = Intent(this, SignUpActivity::class.java)
        startActivity(intent)
    }

    private fun switchToSwitchActivity() {
        Log.d(TAG, "switchToSwitchActivity: started.")
        val intent = Intent(this, SwitchActivity::class.java)
        startActivity(intent)
    }
}
