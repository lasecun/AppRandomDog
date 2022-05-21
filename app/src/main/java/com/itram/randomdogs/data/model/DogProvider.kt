package com.itram.randomdogs.data.model

import javax.inject.Inject

class DogProvider @Inject constructor() {
    var dog: DogModel = DogModel("", "")
}