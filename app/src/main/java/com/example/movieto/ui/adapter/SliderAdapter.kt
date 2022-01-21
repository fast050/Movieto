package com.example.movieto.ui.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


import androidx.viewpager2.widget.ViewPager2

import com.example.movieto.databinding.ViewPagerMovieItemBinding


class SliderAdapter(
    private val sliderItems: ArrayList<SliderItems>,
    private val viewPager2: ViewPager2
) :
    RecyclerView.Adapter<SliderAdapter.SliderViewHolder>() {

    private val runnable = Runnable {
        sliderItems.addAll(sliderItems)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SliderViewHolder {

        val binding =
            ViewPagerMovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SliderViewHolder(binding)

    }

    override fun onBindViewHolder(holder: SliderViewHolder, position: Int) {
        holder.bind(sliderItems[position])

        if (position == sliderItems.size - 2) {
            viewPager2.post(runnable)
        }
    }

    override fun getItemCount(): Int {
        return sliderItems.size
    }

    inner class SliderViewHolder(private val binding: ViewPagerMovieItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(sliderItems: SliderItems) {
            binding.apply {
                //use glide or picasso in case you get image from internet
                imageSlide.setImageResource(sliderItems.image)
            }

        }

    }


}


data class SliderItems(  //set to String, if you want to add image url from internet
    val image: Int
)
