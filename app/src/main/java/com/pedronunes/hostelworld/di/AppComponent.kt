package com.pedronunes.hostelworld.di

import com.pedronunes.hostelworld.data.api.PropertyService
import com.pedronunes.hostelworld.data.repositories.PropertyRepository
import com.pedronunes.hostelworld.viewmodel.PropertiesViewModel
import com.pedronunes.hostelworld.viewmodel.PropertiesViewModelFactory
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun getPropertyRepository(): PropertyRepository
    fun getPropertiesViewModel(): PropertiesViewModel
    fun getPropertiesViewModelFactory(): PropertiesViewModelFactory
    fun getPropertyService(): PropertyService
}