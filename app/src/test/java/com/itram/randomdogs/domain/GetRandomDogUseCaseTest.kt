package com.itram.randomdogs.domain

import com.itram.randomdogs.data.DogRepository
import com.itram.randomdogs.domain.model.Dog
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetRandomDogUseCaseTest {

    @RelaxedMockK
    private lateinit var repository: DogRepository

    lateinit var getRandomDogUseCase: GetRandomDogUseCase

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        getRandomDogUseCase = GetRandomDogUseCase(repository)
    }

    @Test
    fun `check if the API it's call at least one time`() = runBlocking {
        //Given
        coEvery { repository.getRandomDogFromApi() } returns Dog("")
        //When
        getRandomDogUseCase()
        //Then
        coVerify(exactly = 1) { repository.getRandomDogFromApi() }
    }

    @Test
    fun `return default image if the image returned is empty string`() = runBlocking {
        //Given
        val dog = Dog("")
        coEvery { repository.getRandomDogFromApi() } returns dog
        //When
        val response = getRandomDogUseCase()
        //Then
        assert(response.image == "default")
    }
}