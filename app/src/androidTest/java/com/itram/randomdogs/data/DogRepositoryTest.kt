package com.itram.randomdogs.data

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.itram.randomdogs.data.database.DogDatabase
import com.itram.randomdogs.data.database.dao.DogDao
import com.itram.randomdogs.data.database.entities.DogEntity
import com.itram.randomdogs.data.network.DogService
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test

class DogRepositoryTest {

    private lateinit var database: DogDatabase
    private lateinit var dogDao: DogDao
    private lateinit var dogService: DogService

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        database = Room.inMemoryDatabaseBuilder(context, DogDatabase::class.java).build()
        dogDao = database.getDogDao()
        dogService = DogService(mockk())
    }

    @After
    fun closeDb() {
        database.close()
    }

    @Test
    fun insertNewDogInTheDatabase() = runTest {
        //Given
        val localDataSource = DogRepository(dogService, dogDao)
        //When
        localDataSource.insertDogs(DogEntity(22, "Test1", "Image1"))
        //Then
        assert(localDataSource.isDogSaved("22"))
    }
}