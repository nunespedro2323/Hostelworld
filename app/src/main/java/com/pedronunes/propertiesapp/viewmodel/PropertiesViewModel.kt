package com.pedronunes.propertiesapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pedronunes.propertiesapp.data.models.Properties
import com.pedronunes.propertiesapp.data.repositories.PropertyRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers

import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class PropertiesViewModel @Inject constructor(private val propertyRepository: PropertyRepository) :
    ViewModel() {
    private val compositeDisposable = CompositeDisposable()
    private val _properties = MutableLiveData<Properties>()
    val properties: LiveData<Properties> get() = _properties

    fun fetchProperties() {
        compositeDisposable.add(
            propertyRepository.getProperties().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe({ properties ->
                    _properties.value = properties
                }, { error ->
                    //TODO: Finish error
                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}
