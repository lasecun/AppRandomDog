package com.itram.randomdogs.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.itram.randomdogs.data.database.dao.DogDao
import com.itram.randomdogs.data.database.entities.DogEntity

@Database(entities = [DogEntity::class], version = 1)
abstract class DogDatabase : RoomDatabase() {

    abstract fun getDogDao(): DogDao

}