package com.itram.randomdogs.domain.model

import com.itram.randomdogs.data.database.entities.DogEntity
import com.itram.randomdogs.data.model.DogModel

data class Dog(
    val image: String,
)

fun DogModel.toDomain() = Dog(message)
fun DogEntity.toDomain() = Dog(image)

