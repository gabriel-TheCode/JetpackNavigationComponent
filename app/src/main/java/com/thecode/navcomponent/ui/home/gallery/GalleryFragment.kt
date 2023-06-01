package com.thecode.navcomponent.ui.home.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.thecode.navcomponent.NavigationManager
import com.thecode.navcomponent.databinding.FragmentGalleryBinding

class GalleryFragment : Fragment() {

    companion object {
        fun newInstance() = GalleryFragment()
    }

    private var _binding: FragmentGalleryBinding? = null

    private val binding get() = _binding!!

    private lateinit var viewModel: GalleryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGalleryBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[GalleryViewModel::class.java]

        binding.openButton.setOnClickListener {
            NavigationManager().goToGalleryDetails(binding.root, "Gallery Details")
        }
    }
}