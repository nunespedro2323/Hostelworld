package com.pedronunes.hostelworld.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.pedronunes.hostelworld.databinding.FragmentPropertyDetailsBinding

class PropertyDetailsFragment : Fragment() {
    private lateinit var binding: FragmentPropertyDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentPropertyDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }
}