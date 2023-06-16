package com.pedronunes.hostelworld.data.api

import com.pedronunes.hostelworld.data.RetrofitClient
import com.pedronunes.hostelworld.data.models.Properties
import io.reactivex.rxjava3.core.Single

class PropertyApi {
    private val propertyService = RetrofitClient.propertyService

    fun getProperties(): Single<Properties> {
        return propertyService.getProperties()
    }
}
