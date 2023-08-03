package com.pedronunes.propertiesapp.data.api

import com.pedronunes.propertiesapp.data.models.Properties
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface PropertyService {
    @GET("properties.json")
    fun getProperties(): Single<Properties>
}