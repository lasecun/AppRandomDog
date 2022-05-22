package com.itram.randomdogs.ui.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.itram.randomdogs.domain.GetRandomDogUseCase
import com.itram.randomdogs.domain.model.Dog
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class DogViewModelTest {

    @RelaxedMockK
    private lateinit var getRandomDogUseCase: GetRandomDogUseCase

    private lateinit var dogViewModel: DogViewModel

    @get:Rule
    val rule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        dogViewModel = DogViewModel(getRandomDogUseCase)
        Dispatchers.setMain(Dispatchers.Unconfined)
    }

    @After
    fun onAfter() {
        Dispatchers.resetMain()
    }

    @Test
    fun `onCreate return a random dog`() = runTest {
        //Given
        val dog = Dog("www.google.es")
        coEvery { getRandomDogUseCase() } returns dog
        //When
        dogViewModel.onCreate()
        //Then
        assert(dogViewModel.randomImage.value == dog.image)
    }
}