package com.itram.randomdogs.domain

import com.itram.randomdogs.data.DogRepository
import javax.inject.Inject

class GetTotalNumberOfFavoritesUseCase @Inject constructor(
    private val repository: DogRepository,
) {
    suspend operator fun invoke(): Int {
        return repository.totalFavDogs()
    }
}