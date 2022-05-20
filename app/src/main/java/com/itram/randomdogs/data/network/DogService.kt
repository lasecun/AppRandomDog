package com.itram.randomdogs.data.network

import com.itram.randomdogs.core.RetrofitHelper
import com.itram.randomdogs.data.model.DogResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DogService {
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getRandomDog(): DogResponse {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(ApiClient::class.java).getRandomDog()
            response.body() ?: DogResponse("", "")
        }
    }
}