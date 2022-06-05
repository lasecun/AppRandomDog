package com.itram.randomdogs.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.itram.randomdogs.domain.AddDogToFavorites
import com.itram.randomdogs.domain.GetRandomDogUseCase
import com.itram.randomdogs.domain.GetTotalNumberOfFavoritesUseCase
import com.itram.randomdogs.domain.model.Dog
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.net.URL
import javax.inject.Inject

@HiltViewModel
class DogViewModel @Inject constructor(
    private val getRandomDogUseCase: GetRandomDogUseCase,
    private val getTotalNumberOfFavoritesUseCase: GetTotalNumberOfFavoritesUseCase,
    private val addDogToFavorites: AddDogToFavorites,
) : ViewModel() {

    private val _randomImage = MutableLiveData<String>()
    var randomImage: LiveData<String> = _randomImage

    private val _totalFavorites = MutableLiveData<String>()
    var totalFavorites: LiveData<String> = _totalFavorites

    private val _isLoading = MutableLiveData<Boolean>()
    var isLoading: LiveData<Boolean> = _isLoading

    fun onCreate() {
        randomDog()
        updateFavoritesNumber()
    }

    private fun updateFavoritesNumber() {
        viewModelScope.launch {
            val result = getTotalNumberOfFavoritesUseCase().toString()
            _totalFavorites.value = result
        }
    }

    fun randomDog() {
        viewModelScope.launch {
            _isLoading.postValue(true)
            val result = getRandomDogUseCase()
            _randomImage.postValue(result.image)
            _isLoading.postValue(false)
        }
    }

    fun addToFavorites() {
        val breed = getBreedFromUrl(randomImage.value.toString())
        viewModelScope.launch {
            addDogToFavorites.invoke(Dog(randomImage.value.toString(), breed))
            updateFavoritesNumber()
        }
    }

    private fun getBreedFromUrl(url: String): String {
        return URL(url).path.split("/")[2]
    }
}