package com.itram.randomdogs.data.network

import com.itram.randomdogs.data.model.DogModel
import retrofit2.Response
import retrofit2.http.GET

interface DogApiClient {
    @GET("image/random/")
    suspend fun getRandomDog(): Response<DogModel>
}