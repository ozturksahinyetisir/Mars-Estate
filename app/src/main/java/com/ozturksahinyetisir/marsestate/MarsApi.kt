package com.ozturksahinyetisir.marsestate

import com.ozturksahinyetisir.marsestate.views.RealEstateModel
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MarsApi {
    /**
     * retrofit get mars API & GsonConverterFactory get json values.
     */
    private val BASE_URL = "https://mars.udacity.com/"


    val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()
        .create(MarsApiService::class.java)


    fun getMarsData(): Call<List<RealEstateModel>> {
        return retrofit.getProperties()


    }


}