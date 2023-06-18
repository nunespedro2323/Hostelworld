package com.pedronunes.hostelworld.ui.adapters

import android.annotation.SuppressLint
import android.text.SpannableString
import android.text.Spanned
import android.text.style.StrikethroughSpan
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pedronunes.hostelworld.R
import com.pedronunes.hostelworld.data.models.Property
import com.pedronunes.hostelworld.databinding.ViewItemPropertyListBinding
import com.pedronunes.hostelworld.util.*
import java.util.*

class PropertyAdapter : RecyclerView.Adapter<PropertyAdapter.PropertyViewHolder>() {
    private var list: List<Property> = listOf()
    private var itemClickListener: OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PropertyViewHolder {
        val binding =
            ViewItemPropertyListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PropertyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PropertyViewHolder, position: Int) =
        holder.bind(list[position])

    override fun getItemCount() = list.size

    fun setOnItemClickListener(listener: OnItemClickListener) {
        itemClickListener = listener
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setupList(list: List<Property>) {
        this.list = list
        notifyDataSetChanged()
    }

    inner class PropertyViewHolder(private val binding: ViewItemPropertyListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(property: Property) {
            binding.property = property

            // Load property image using Glide
            Glide.with(binding.root)
                .load("https://" + property.imagesGallery[0].prefix + property.imagesGallery[0].suffix)
                .override(com.bumptech.glide.request.target.Target.SIZE_ORIGINAL)
                .into(binding.imageViewProperty)

            binding.textViewRatingMeaning.text =
                property.overallRating?.overall?.convertToStringRatingMeaning(binding.root.context)
                    ?: ""

            val olderPriceSpannableString = SpannableString(
                binding.root.context.getString(
                    R.string.price,
                    property.lowestAverageDormPricePerNight?.getOriginalValueString()
                )
            )
            olderPriceSpannableString.setSpan(
                StrikethroughSpan(),
                0,
                olderPriceSpannableString.length,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
            )
            binding.textViewPriceOlder.text = olderPriceSpannableString

            val olderPrivatePriceSpannableString = SpannableString(
                binding.root.context.getString(
                    R.string.price,
                    property.lowestAveragePrivatePricePerNight?.getOriginalValueString()
                )
            )
            olderPrivatePriceSpannableString.setSpan(
                StrikethroughSpan(),
                0,
                olderPrivatePriceSpannableString.length,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
            )
            binding.textViewPrivatePriceOlder.text = olderPrivatePriceSpannableString

            itemView.setOnClickListener {
                itemClickListener?.onItemClick(property, layoutPosition)
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(property: Property, position: Int)
    }
}