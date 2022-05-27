package com.itram.randomdogs.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.itram.randomdogs.data.database.entities.DogEntity

@Dao
interface DogDao {
    @Query("SELECT * FROM dog_table")
    suspend fun getAllDogs(): List<DogEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNewDog(dog: DogEntity)

    @Query("SELECT EXISTS(SELECT * FROM dog_table WHERE id = :key)")
    suspend fun isDogSaved(key: String): Boolean
}