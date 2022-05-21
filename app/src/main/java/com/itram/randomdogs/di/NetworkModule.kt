package com.itram.randomdogs.di

import com.itram.randomdogs.data.network.DogApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

///////////////////////////////////////////////////////////////////////////
// Provdes libreries dependencias or clases with interfaces
///////////////////////////////////////////////////////////////////////////

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://dog.ceo/api/breeds/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideDogApiClient(retrofit: Retrofit): DogApiClient {
        return retrofit.create(DogApiClient::class.java)
    }
}