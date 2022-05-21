package com.itram.randomdogs.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.itram.randomdogs.domain.model.Dog

@Entity(tableName = "dog_table")
data class DogEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "image") val image: String,
) {
}

fun Dog.toDatabase() = DogEntity(image = image, name = "")