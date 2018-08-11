package com.alwaysbaked.flagsandcontacts.flags.util

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.layout_country.view.*

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val mCountry = itemView.tvCountry!!
    val mPopulation = itemView.tvPopulation!!
    val mFlag = itemView.ivFlag!!
    val mItem = itemView.rlItem!!

}
