package com.thecode.navcomponent.ui.home

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.thecode.navcomponent.ui.home.gallery.GalleryFragment


class GalleryViewPagerAdapter(
    fragmentActivity: FragmentActivity,
    private val context: Context? = null
) :
    FragmentStateAdapter(fragmentActivity) {

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> GalleryFragment()
            1 -> GalleryFragment()
            else -> GalleryFragment()
        }
    }

    override fun getItemCount(): Int {
        return 3
    }
}