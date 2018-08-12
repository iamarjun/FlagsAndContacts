package com.alwaysbaked.flagsandcontacts.flags.dependencyinjection

import com.alwaysbaked.flagsandcontacts.flags.model.Root
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET

interface API {

    @get:GET("tutorial/jsonparsetutorial.txt")
    val theWorldPopulation: Single<Root>

}