package com.pedronunes.hostelworld.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.pedronunes.hostelworld.data.models.Property
import com.pedronunes.hostelworld.databinding.FragmentPropertyListBinding
import com.pedronunes.hostelworld.ui.MainActivity
import com.pedronunes.hostelworld.ui.adapters.PropertyAdapter
import com.pedronunes.hostelworld.viewmodel.PropertiesViewModel

class PropertyListFragment : Fragment() {
    private lateinit var binding: FragmentPropertyListBinding
    private var propertyAdapter = PropertyAdapter()
    private lateinit var propertiesViewModel: PropertiesViewModel
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentPropertyListBinding.inflate(inflater, container, false)
        propertiesViewModel = (activity as MainActivity).propertiesViewModel
        navController = (activity as MainActivity).navController
        setupList()
        propertiesViewModel.properties.observe(this) {
            propertyAdapter.setupList(it.properties)
        }
        return binding.root
    }

    private fun setupList() {
        binding.recyclerView.run {
            layoutManager = LinearLayoutManager(context)
            propertyAdapter.setOnItemClickListener(object : PropertyAdapter.OnItemClickListener {
                override fun onItemClick(property: Property, position: Int) {
                    val city = propertiesViewModel.properties.value?.location?.city?.name ?: ""
                    val country =
                        propertiesViewModel.properties.value?.location?.city?.country ?: ""

                    val action =
                        PropertyListFragmentDirections.actionPropertyListFragmentToPropertyDetailsFragment(
                            position, city, country
                        )
                    navController.navigate(action)
                }
            })
            adapter = propertyAdapter
        }
    }
}