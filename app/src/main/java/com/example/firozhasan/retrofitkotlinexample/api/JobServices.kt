package com.example.firozhasan.retrofitkotlinexample.api

import com.example.firozhasan.retrofitkotlinexample.`interface`.Constant
import com.example.firozhasan.retrofitkotlinexample.models.Country
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface JobServices {

    @GET(Constant.CAPITAL)
    fun getKountry(@Path("capital") capitalOfCountry: String): Call<List<Country>>
}