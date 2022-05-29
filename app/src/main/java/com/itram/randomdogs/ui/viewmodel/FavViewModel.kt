package com.itram.randomdogs.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.itram.randomdogs.data.database.entities.DogEntity
import com.itram.randomdogs.domain.GetFavoritesDogs
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavViewModel @Inject constructor(
    private val getTotalFavDogs: GetFavoritesDogs,
) : ViewModel() {

    private val _totalFavDogs = MutableLiveData<List<DogEntity>>()
    val totalFavDogs: LiveData<List<DogEntity>> = _totalFavDogs

    fun onCreate() {
        petList()
    }

    private fun petList() {
        viewModelScope.launch {
            _totalFavDogs.postValue(getTotalFavDogs.invoke())
        }
    }
}