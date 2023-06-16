package com.pedronunes.hostelworld.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.pedronunes.hostelworld.databinding.FragmentPropertyListBinding
import com.pedronunes.hostelworld.ui.MainActivity
import com.pedronunes.hostelworld.ui.adapters.PropertyAdapter
import com.pedronunes.hostelworld.viewmodel.PropertiesViewModel

class PropertyListFragment : Fragment() {
    private lateinit var binding: FragmentPropertyListBinding
    private var propertyAdapter = PropertyAdapter()
    private lateinit var propertiesViewModel: PropertiesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentPropertyListBinding.inflate(inflater, container, false)
        propertiesViewModel = (activity as MainActivity).propertiesViewModel
        setupList()
        propertiesViewModel.properties.observe(this) {
            propertyAdapter.setupList(it.properties)
        }
        return binding.root
    }

    private fun setupList() {
        binding.recyclerView.run {
            layoutManager = LinearLayoutManager(context)
            adapter = propertyAdapter
        }
    }
}