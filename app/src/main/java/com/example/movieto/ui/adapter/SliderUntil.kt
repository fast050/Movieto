package com.example.movieto.ui.adapter

import android.os.Handler
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import kotlin.math.abs



fun setAutoScrolling(
    viewPagerImageSlider: ViewPager2,
    sliderRunnable: Runnable,
    sliderHandler: Handler
)
{

    viewPagerImageSlider.clipToPadding = false;
    viewPagerImageSlider.clipChildren = false;
    viewPagerImageSlider.offscreenPageLimit = 3;
    viewPagerImageSlider.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER;

    val compositePageTransformer = CompositePageTransformer();
    compositePageTransformer.addTransformer( MarginPageTransformer(0));
    compositePageTransformer.addTransformer { page, position ->
        val r = 1 - abs(position)
        page.scaleY = 0.85f + r * 0.15f
    }

    viewPagerImageSlider.setPageTransformer(compositePageTransformer)


    viewPagerImageSlider.registerOnPageChangeCallback( object : ViewPager2.OnPageChangeCallback()
    {
        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)
            sliderHandler.removeCallbacks(sliderRunnable)
            sliderHandler.postDelayed(sliderRunnable, 2000); // slide duration 2 seconds

        }

    })
}