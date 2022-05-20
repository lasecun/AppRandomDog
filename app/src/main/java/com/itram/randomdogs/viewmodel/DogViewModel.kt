package com.itram.randomdogs.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.itram.randomdogs.model.APIService
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DogViewModel : ViewModel() {

    private val _randomImage = MutableLiveData<String>()
    var randomImage: LiveData<String> = _randomImage

    init {
        getRandomDog()
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://dog.ceo/api/breeds/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getRandomDog() {
        viewModelScope.launch {
            val call = getRetrofit().create(APIService::class.java).getRandomDog("image/random/")
            val dog = call.body()
            if (call.isSuccessful) {
                val images = dog?.image ?: ""
                _randomImage.postValue(images)
            }
        }
    }


}