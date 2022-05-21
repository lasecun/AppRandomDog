package com.itram.randomdogs.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.itram.randomdogs.domain.GetRandomDogUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DogViewModel @Inject constructor(
    private val getRandomDogUseCase: GetRandomDogUseCase,
) : ViewModel() {

    private val _randomImage = MutableLiveData<String>()
    var randomImage: LiveData<String> = _randomImage

    private val _isLoading = MutableLiveData<Boolean>()
    var isLoading: LiveData<Boolean> = _isLoading

    fun onCreate() {
        randomDog()
    }

    fun randomDog() {
        viewModelScope.launch {
            _isLoading.postValue(true)
            val result = getRandomDogUseCase()
            _randomImage.postValue(result.image)
            _isLoading.postValue(false)
        }
    }
}