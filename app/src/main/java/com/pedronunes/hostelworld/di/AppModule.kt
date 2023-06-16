package com.pedronunes.hostelworld.di

import com.pedronunes.hostelworld.data.RetrofitClient
import com.pedronunes.hostelworld.data.api.PropertyApi
import com.pedronunes.hostelworld.data.api.PropertyService
import com.pedronunes.hostelworld.data.repositories.PropertyRepository
import com.pedronunes.hostelworld.viewmodel.PropertiesViewModel
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class AppModule {
    @Singleton
    @Provides
    fun providePropertyService(): PropertyService {
        return RetrofitClient.propertyService
    }


    @Singleton
    @Provides
    fun providePropertyApi(): PropertyApi {
        return PropertyApi()
    }

    @Singleton
    @Provides
    fun providePropertyRepository(propertyApi: PropertyApi): PropertyRepository {
        return PropertyRepository(propertyApi)
    }

    // Provide the PropertiesViewModel instance
    @Provides
    fun providePropertiesViewModel(repository: PropertyRepository): PropertiesViewModel {
        return PropertiesViewModel(repository)
    }
}