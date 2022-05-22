package com.itram.randomdogs.data.model

import com.google.gson.annotations.SerializedName

data class DogModel(
    @SerializedName("status") var status: String,
    @SerializedName("message") var message: String,
)
