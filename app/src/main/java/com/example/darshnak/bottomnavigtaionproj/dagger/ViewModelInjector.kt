package com.example.darshnak.bottomnavigtaionproj.dagger

import com.example.darshnak.bottomnavigtaionproj.MainActivity
import com.example.darshnak.daggerproject.module.NetworkModule
import dagger.Component
import javax.inject.Singleton


/**
 * Component providing inject() methods for presenters.
 */
@Singleton
@Component(modules = [(NetworkModule::class)])
interface ViewModelInjector {


    /**
     * Injects required dependencies into the specified MainActivity.
     * @param postViewModel MainActivity in which to inject the dependencies
     */
    fun inject(mainActivity: MainActivity)


    @Component.Builder
    interface Builder {
        fun build(): ViewModelInjector
        fun networkModule(networkModule: NetworkModule): Builder
    }
}