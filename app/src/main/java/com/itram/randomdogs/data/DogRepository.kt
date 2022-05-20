package com.itram.randomdogs.data

import com.itram.randomdogs.data.model.DogProvider
import com.itram.randomdogs.data.model.DogResponse
import com.itram.randomdogs.data.network.DogService

class DogRepository {
    private val api = DogService()

    suspend fun getRandomDog(): DogResponse {
        val response = api.getRandomDog()
        DogProvider.dog = response
        return response
    }
}