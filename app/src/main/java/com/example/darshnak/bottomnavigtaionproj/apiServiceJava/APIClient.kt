package com.example.darshnak.bottomnavigtaionproj.apiServiceJava
import dagger.Module
import dagger.Provides
import dagger.Reusable
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

/**
 * Purpose of this class to get retrofit class instance
 * Created by Darshna Kumari on 28/05/2019.
 */
@Module
 class APIClient @Inject constructor() {
    private val BASE_URL = "http://proacdoc.com/Service1.svc/"

    /**
     * Method use to provide retrofit instance
     * @return retrofit instance
     */
    @Provides
    @Reusable
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    /**
     * This method use to make connection in b/w API client(Retrofit) and API Interface.
     * @return APIInterface API Interface class Instance.
     */
    @Provides
    @Reusable
    fun providePostApi(retrofit: Retrofit): APIInterface {
        return retrofit.create(APIInterface::class.java)
    }

}
