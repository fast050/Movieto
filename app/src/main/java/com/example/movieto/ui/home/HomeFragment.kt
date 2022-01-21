package com.example.movieto.ui.home


import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.viewModels


import com.example.movieto.R
import com.example.movieto.databinding.HomeFragmentBinding


import com.example.movieto.ui.adapter.SliderAdapter
import com.example.movieto.ui.adapter.SliderItems
import com.example.movieto.ui.adapter.setAutoScrolling


class HomeFragment : Fragment() {

    private val viewModel by viewModels<HomeViewModel>()
    private var _binding: HomeFragmentBinding? = null
    private lateinit var sliderRunnable: Runnable
    private val sliderHandler = Handler()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = HomeFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.apply {
            setViewPagerAdapter()
        }

    }

    private fun HomeFragmentBinding.setViewPagerAdapter() {
        val sliderItems = ArrayList<SliderItems>();
        sliderItems.add(SliderItems(R.drawable.img));
        sliderItems.add(SliderItems(R.drawable.img_1));
        sliderItems.add(SliderItems(R.drawable.img_2));
        sliderItems.add(SliderItems(R.drawable.img_3));

        val adapter = SliderAdapter(sliderItems,viewPagerImageSliderHomeFragment )

        viewPagerImageSliderHomeFragment.adapter = adapter


        sliderRunnable = Runnable {
            viewPagerImageSliderHomeFragment.currentItem = viewPagerImageSliderHomeFragment.currentItem + 1
        }
        setAutoScrolling(viewPagerImageSliderHomeFragment, sliderRunnable, sliderHandler)
    }


    override fun onPause() {
        super.onPause()
        sliderHandler.removeCallbacks(sliderRunnable)
    }

    override fun onResume() {
        super.onResume()
        sliderHandler.postDelayed(sliderRunnable, 2000)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}