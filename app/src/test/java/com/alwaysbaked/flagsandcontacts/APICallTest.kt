package com.alwaysbaked.flagsandcontacts

import android.util.Log
import com.alwaysbaked.flagsandcontacts.flags.model.Root
import com.alwaysbaked.flagsandcontacts.flags.retrofit.APIService
import junit.framework.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@RunWith(JUnit4::class)
class APICallTest {
    companion object {
        private const val TAG = "APICallTest"
    }

    private val apiServe by lazy {
        APIService.create()
    }

    private var code: String = ""

    @Test
    fun apiTest() {

        val root: Call<Root> = apiServe.response

        root.enqueue(object : Callback<Root> {
            override fun onResponse(call: Call<Root>, response: Response<Root>) {
                code = response.code().toString()

            }

            override fun onFailure(call: Call<Root>, t: Throwable) {
                Log.e(TAG, "onFailure: ", t.cause)

            }

        })

        try {
            Thread.sleep(3000)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }

        assertEquals("200", code)

    }
}