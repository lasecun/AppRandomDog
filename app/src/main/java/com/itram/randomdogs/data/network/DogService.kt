package com.itram.randomdogs.data.network

import com.itram.randomdogs.data.model.DogModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DogService @Inject constructor(private val api: DogApiClient) {

    suspend fun getRandomDog(): DogModel {
        return withContext(Dispatchers.IO) {
            val response = api.getRandomDog()
            response.body() ?: DogModel("", "")
        }
    }
}