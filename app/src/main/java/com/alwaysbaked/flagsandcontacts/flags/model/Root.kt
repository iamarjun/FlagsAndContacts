package com.alwaysbaked.flagsandcontacts.flags.model

import com.google.gson.annotations.SerializedName

data class Root(
        @SerializedName("worldpopulation") val worldpopulation: List<Worldpopulation>
)