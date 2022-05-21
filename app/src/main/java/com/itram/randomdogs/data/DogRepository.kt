package com.itram.randomdogs.data

import com.itram.randomdogs.data.model.DogModel
import com.itram.randomdogs.data.model.DogProvider
import com.itram.randomdogs.data.network.DogService
import javax.inject.Inject

class DogRepository @Inject constructor(
    private val api: DogService,
    private val dogProvider: DogProvider,
) {

    suspend fun getRandomDog(): DogModel {
        val response = api.getRandomDog()
        dogProvider.dog = response
        return response
    }
}