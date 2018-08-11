package com.alwaysbaked.flagsandcontacts

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.alwaysbaked.flagsandcontacts.contacts.ContactsActivity
import com.alwaysbaked.flagsandcontacts.flags.FlagActivity
import kotlinx.android.synthetic.main.activity_switch.*

class SwitchActivity : AppCompatActivity() {
    companion object {
        private const val TAG = "SwitchActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_switch)
        Log.d(TAG, "onCreate: started.")

        btnFlags.setOnClickListener {
            Log.d(TAG, "onCreate:  btnFlags.setOnClickListener started")
            val intent = Intent(this, FlagActivity::class.java)
            startActivity(intent)
        }

        btnContacts.setOnClickListener {
            Log.d(TAG, "onCreate:  btnContacts.setOnClickListener started")
            val intent = Intent(this, ContactsActivity::class.java)
            startActivity(intent)
        }

    }
}
