package com.example.darshnak.bottomnavigtaionproj.apiServiceJava
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Url

/**
 * Purpose of this class to declare and access all API response.
 * Created by Darshna Kumari on 28/05/2019.
 */
interface APIInterface {
    @GET("{fullUrl}")
    fun getAllHeros_(@Path(value = "fullUrl", encoded = true) fullUrl: String): Call<ResponseBody>

    @GET("{fullUrl}")
    fun getUpComingEvents(@Path(value = "fullUrl", encoded = true) fullUrl: String): Call<ResponseBody>

}
