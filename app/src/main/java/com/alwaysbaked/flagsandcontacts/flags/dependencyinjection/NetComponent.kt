package com.alwaysbaked.flagsandcontacts.flags.dependencyinjection

import com.alwaysbaked.flagsandcontacts.flags.FlagActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(NetModule::class))
interface NetComponent {
    fun inject(application: FlagActivity)
}