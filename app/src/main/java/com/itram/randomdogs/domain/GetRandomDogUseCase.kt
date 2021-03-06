package com.itram.randomdogs.domain

import com.itram.randomdogs.data.DogRepository
import com.itram.randomdogs.domain.model.Dog
import javax.inject.Inject

class GetRandomDogUseCase @Inject constructor(
    private val repository: DogRepository,
) {
    suspend operator fun invoke(): Dog {
        return repository.getRandomDogFromApi()
    }
}