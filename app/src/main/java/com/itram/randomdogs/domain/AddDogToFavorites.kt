package com.itram.randomdogs.domain

import com.itram.randomdogs.data.DogRepository
import com.itram.randomdogs.data.database.entities.toDatabase
import com.itram.randomdogs.domain.model.Dog
import javax.inject.Inject

class AddDogToFavorites @Inject constructor(
    private val repository: DogRepository,
) {
    suspend operator fun invoke(dog: Dog) {
        repository.insertDogs(dog.toDatabase())
    }
}