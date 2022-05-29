package com.itram.randomdogs.domain

import com.itram.randomdogs.data.DogRepository
import com.itram.randomdogs.data.database.entities.DogEntity
import javax.inject.Inject

class GetFavoritesDogs @Inject constructor(
    private val repository: DogRepository,
) {

    suspend operator fun invoke(): List<DogEntity> {
        return repository.getFavDogsList()
    }
}