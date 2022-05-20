package com.itram.randomdogs.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.itram.randomdogs.domain.GetRandomDogUseCase
import kotlinx.coroutines.launch

class DogViewModel : ViewModel() {

    private val _randomImage = MutableLiveData<String>()
    var randomImage: LiveData<String> = _randomImage
    var getRandomDogUseCase = GetRandomDogUseCase()

//    init {
//        getRandomDog()
//    }

    fun onCreate() {
        viewModelScope.launch {
            val result = getRandomDogUseCase()
            _randomImage.postValue(result.image)
        }
    }

//    private fun getRetrofit(): Retrofit {
//        return Retrofit.Builder()
//            .baseUrl("https://dog.ceo/api/breeds/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//    }

//    fun getRandomDog() {
//        viewModelScope.launch {
//            val call = getRetrofit().create(APIService::class.java).getRandomDog("image/random/")
//            val dog = call.body()
//            if (call.isSuccessful) {
//                val images = dog?.image ?: ""
//                _randomImage.postValue(images)
//            }
//        }
//    }

}