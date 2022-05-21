package com.itram.randomdogs.domain

import com.itram.randomdogs.data.DogRepository
import com.itram.randomdogs.data.model.DogModel
import javax.inject.Inject

class GetRandomDogUseCase @Inject constructor(
    private val repository: DogRepository,
) {
    suspend operator fun invoke(): DogModel = repository.getRandomDog()
}