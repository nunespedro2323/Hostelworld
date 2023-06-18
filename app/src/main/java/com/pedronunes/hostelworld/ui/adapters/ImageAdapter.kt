package com.pedronunes.hostelworld.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pedronunes.hostelworld.data.models.Images
import com.pedronunes.hostelworld.databinding.ViewItemImageListBinding
import com.pedronunes.hostelworld.util.*
import java.util.*

class ImageAdapter(private val list: List<Images>) :
    RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val binding =
            ViewItemImageListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ImageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) =
        holder.bind(list[position])

    override fun getItemCount() = list.size

    inner class ImageViewHolder(private val binding: ViewItemImageListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(images: Images) {
            // Load property image using Glide
            Glide.with(binding.root).load("https://" + images.prefix + images.suffix)
                .into(binding.imageViewProperty)
        }
    }
}