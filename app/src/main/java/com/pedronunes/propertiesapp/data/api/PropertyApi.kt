package com.pedronunes.propertiesapp.data.api

import com.pedronunes.propertiesapp.data.RetrofitClient
import com.pedronunes.propertiesapp.data.models.Properties
import io.reactivex.rxjava3.core.Single

class PropertyApi {
    private val propertyService = RetrofitClient.propertyService

    fun getProperties(): Single<Properties> {
        return propertyService.getProperties()
    }
}
