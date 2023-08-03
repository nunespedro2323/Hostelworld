package com.pedronunes.propertiesapp.di

import com.pedronunes.propertiesapp.data.api.PropertyService
import com.pedronunes.propertiesapp.data.repositories.PropertyRepository
import com.pedronunes.propertiesapp.viewmodel.PropertiesViewModel
import com.pedronunes.propertiesapp.viewmodel.PropertiesViewModelFactory
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