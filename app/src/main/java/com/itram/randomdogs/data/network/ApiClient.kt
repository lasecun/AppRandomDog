package com.itram.randomdogs.data.network

import com.itram.randomdogs.data.model.DogResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiClient {
    @GET("image/random/")
    suspend fun getRandomDog(): Response<DogResponse>
}