package com.itram.randomdogs.domain

import com.itram.randomdogs.data.DogRepository
import com.itram.randomdogs.data.model.DogResponse

class GetRandomDogUseCase {

    private val repository = DogRepository()

    suspend operator fun invoke(): DogResponse = repository.getRandomDog()
}