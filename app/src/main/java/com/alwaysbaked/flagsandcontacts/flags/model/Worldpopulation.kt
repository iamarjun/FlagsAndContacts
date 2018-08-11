package com.alwaysbaked.flagsandcontacts.flags.model

import com.google.gson.annotations.SerializedName


data class Worldpopulation(
        @SerializedName("rank") val rank: Int,
        @SerializedName("country") val country: String,
        @SerializedName("population") val population: String,
        @SerializedName("flag") val flag: String
)
