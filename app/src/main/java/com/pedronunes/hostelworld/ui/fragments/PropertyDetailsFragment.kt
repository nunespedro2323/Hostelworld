package com.pedronunes.hostelworld.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.pedronunes.hostelworld.R
import com.pedronunes.hostelworld.databinding.FragmentPropertyDetailsBinding
import com.pedronunes.hostelworld.ui.MainActivity
import com.pedronunes.hostelworld.ui.adapters.ImageAdapter
import com.pedronunes.hostelworld.viewmodel.PropertiesViewModel


class PropertyDetailsFragment : Fragment() {
    private lateinit var binding: FragmentPropertyDetailsBinding
    private lateinit var propertiesViewModel: PropertiesViewModel
    private val args: PropertyDetailsFragmentArgs by navArgs()
    private var propertyPosition: Int = 0
    private var propertyCity = ""
    private var propertyCountry = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentPropertyDetailsBinding.inflate(inflater, container, false)
        propertiesViewModel = (activity as MainActivity).propertiesViewModel

        propertyPosition = arguments?.getInt("propertyPosition")!!
        propertyCity = arguments?.getString("propertyCity", "")!!
        propertyCountry = arguments?.getString("propertyCountry", "")!!

        binding.property = propertiesViewModel.properties.value?.properties?.get(propertyPosition)

        binding.textViewLocation.text =
            getString(R.string.location_field, propertyCity, propertyCountry)

        setupMap(savedInstanceState)
        setupListImages()

        return binding.root
    }

    private fun setupListImages() {
        binding.recyclerViewImageslist.run {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = binding.property?.imagesGallery?.let { ImageAdapter(it) }
        }
    }

    private fun setupMap(savedInstanceState: Bundle?) {
        binding.mapView.run {
            onCreate(savedInstanceState)
            getMapAsync { googleMap ->
                val propertyPositionMap = binding.property?.latitude?.let { latitude ->
                    binding.property?.longitude?.let { longitude ->
                        LatLng(latitude, longitude)
                    }
                }

                if (propertyPositionMap != null) {
                    googleMap.addMarker(MarkerOptions().position(propertyPositionMap))
                    val cameraPosition =
                        CameraPosition.builder().target(propertyPositionMap).zoom(16f).build()
                    googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition))
                }
            }
        }
    }
}