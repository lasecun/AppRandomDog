package com.itram.randomdogs.data

import com.itram.randomdogs.data.database.dao.DogDao
import com.itram.randomdogs.data.database.entities.DogEntity
import com.itram.randomdogs.data.model.DogModel
import com.itram.randomdogs.data.network.DogService
import com.itram.randomdogs.domain.model.Dog
import com.itram.randomdogs.domain.model.toDomain
import javax.inject.Inject

class DogRepository @Inject constructor(
    private val api: DogService,
    private val dogDao: DogDao,
) {

    suspend fun getRandomDogFromApi(): Dog {
        val response: DogModel = api.getRandomDog()
        return response.toDomain()
    }

    suspend fun getRandomDogFromDataBase(): List<Dog> {
        val response = dogDao.getAllDogs()
        return response.map { it.toDomain() }
    }

    suspend fun insertDogs(dog: DogEntity) {
        dogDao.insertNewDog(dog)
    }
}