package com.example.darshnak.daggerproject.module
import com.example.darshnak.bottomnavigtaionproj.apiServiceJava.APIInterface
import dagger.Module
import dagger.Provides
import dagger.Reusable
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * Module which provides all required dependencies about network
 */
@Module
// Safe here as we are dealing with a Dagger 2 module
@Suppress("unused")
object NetworkModule {


    /**
     * Provides the DashBoardModel service implementation.
     * @param retrofit the Retrofit object used to instantiate the service
     * @return the DashBoardModel service implementation.
     */
    @Provides
    @Reusable
    @JvmStatic
    internal fun providePostApi(retrofit: Retrofit): APIInterface {
        return retrofit.create(APIInterface::class.java)
    }

    /**
     * Provides the Retrofit object.
     * @return the Retrofit object
     */
    @Provides
    @Reusable
    @JvmStatic
    internal fun provideRetrofitInterface(): Retrofit {
        return Retrofit.Builder()
                .baseUrl("http://proacdoc.com/Service1.svc/" )
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }
}