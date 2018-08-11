package com.alwaysbaked.flagsandcontacts.flags

import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alwaysbaked.flagsandcontacts.R
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.dialog_flag.view.*

class FlagDialog : DialogFragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.dialog_flag, container, false)
        Log.d(TAG, "onCreateView: started")

        val url = arguments!!.getString("Image URL")

        Glide.with(activity!!)
                .asBitmap()
                .load(url)
                .into(view.ivFlag)

        return view
    }

    companion object {
        private val TAG = "FlagDialog"
    }

}
