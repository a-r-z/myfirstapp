package com.example.myfirstapp.presentation.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import com.example.myfirstapp.presentation.detail.CovidDetailResponse

interface Covidapi {

    @GET("countries")
    fun getCovidList(): Call<List<CovidResponse>>
    @GET("country/{id}")
    fun getCovidDetail(@Path("id") id:String): Call<List<CovidDetailResponse>>
}