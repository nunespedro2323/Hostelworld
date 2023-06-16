package com.pedronunes.hostelworld.data.repositories

import com.pedronunes.hostelworld.data.api.PropertyApi
import com.pedronunes.hostelworld.data.models.Properties
import io.reactivex.rxjava3.core.Single

class PropertyRepository(private val propertyApi: PropertyApi) {
    fun getProperties(): Single<Properties> {
        return propertyApi.getProperties()
    }
}