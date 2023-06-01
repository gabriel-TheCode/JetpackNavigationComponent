package com.thecode.navcomponent.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.thecode.navcomponent.R
import com.thecode.navcomponent.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var mViewPager: ViewPager2

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this)[HomeViewModel::class.java]

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root


        homeViewModel.text.observe(viewLifecycleOwner) {
            //textView.text = it
        }

        mViewPager = binding.viewPager
        mViewPager.adapter = GalleryViewPagerAdapter(requireActivity())
        mViewPager.isUserInputEnabled = false
        TabLayoutMediator(binding.tabLayout, mViewPager) { tab, position ->
            mViewPager.setCurrentItem(
                tab.position,
                true
            )
            when (position) {
                0 -> {
                    tab.text = "Tab 1"
                }

                1 -> {
                    tab.text = "Tab 2"
                }

                2 -> {
                    tab.text = "Tab 3"
                }
            }
        }.attach()

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}