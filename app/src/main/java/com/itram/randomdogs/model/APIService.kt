package com.itram.randomdogs.model

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface APIService {
    @GET
    suspend fun getRandomDog(@Url url: String): Response<DogResponse>
}