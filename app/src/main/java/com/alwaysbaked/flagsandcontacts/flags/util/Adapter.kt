package com.alwaysbaked.flagsandcontacts.flags.util

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import com.alwaysbaked.flagsandcontacts.R
import com.alwaysbaked.flagsandcontacts.flags.FlagDialog
import com.alwaysbaked.flagsandcontacts.flags.model.Worldpopulation
import com.bumptech.glide.Glide


class Adapter(private val mContext: Context, private val populationList: List<Worldpopulation>) : RecyclerView.Adapter<ViewHolder>() {
    private val bundle: Bundle = Bundle()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        Log.d(TAG, "onCreateViewHolder: started")
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_country, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d(TAG, "onBindViewHolder: started.")

        holder.mCountry.text = populationList[position].country
        holder.mPopulation.text = populationList[position].population


        Glide.with(mContext)
                .asBitmap()
                .load(populationList[position].flag)
                .into(holder.mFlag)


        holder.mItem.setOnClickListener {
            Log.d(TAG, "onClick: clicked an item on RecyclerView")
            Toast.makeText(mContext, populationList[position].country, Toast.LENGTH_SHORT).show()

            bundle.putString("Image URL", populationList[position].flag)

            val flagDialog = FlagDialog()
            flagDialog.arguments = bundle

            flagDialog.show((mContext as AppCompatActivity).supportFragmentManager, "Flag Dialog")
        }

    }

    override fun getItemCount(): Int {
        return populationList.size
    }

    companion object {
        private val TAG = "Adapter"
    }
}
