package com.thecode.navcomponent.ui.home.gallery.gallerydetails

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.thecode.navcomponent.NavigationManager
import com.thecode.navcomponent.databinding.FragmentGalleryDetailsBinding

class GalleryDetailsFragment : Fragment() {

    private var _binding: FragmentGalleryDetailsBinding? = null

    private val binding get() = _binding!!
    private var albumId : String? = null

    private lateinit var viewModel: GalleryDetailsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            albumId = it.getString(ALBUM_ID)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGalleryDetailsBinding.inflate(inflater, container, false)

        binding.textGalleryDetails.text = albumId
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[GalleryDetailsViewModel::class.java]

        binding.openButton.setOnClickListener {
            NavigationManager().goToGalleryDialog(binding.root)
        }
    }

    companion object {

        private const val ALBUM_ID = "albumId"

        fun newInstance() = GalleryDetailsFragment()
    }

}