package com.ozturksahinyetisir.marsestate

import com.ozturksahinyetisir.marsestate.views.RealEstateModel
import retrofit2.Call
import retrofit2.http.GET

interface MarsApiService {

     @GET("realestate")
     fun getProperties():
             Call<List<RealEstateModel>>
}