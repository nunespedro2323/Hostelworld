package com.pedronunes.propertiesapp.data.repositories

import com.pedronunes.propertiesapp.data.api.PropertyApi
import com.pedronunes.propertiesapp.data.models.Properties
import io.reactivex.rxjava3.core.Single

class PropertyRepository(private val propertyApi: PropertyApi) {
    fun getProperties(): Single<Properties> {
        return propertyApi.getProperties()
    }
}