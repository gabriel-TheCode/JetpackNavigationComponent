package com.thecode.navcomponent.ui.home.gallery.gallerydetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.navigation.findNavController
import com.thecode.navcomponent.R
import com.thecode.navcomponent.databinding.FragmentGalleryDialogBinding


class GalleryDialog2Fragment : DialogFragment() {

    private var _binding: FragmentGalleryDialogBinding? = null

    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        configureWindow()
    }


    private fun configureWindow() {
        dialog?.window?.run {
            val width = ViewGroup.LayoutParams.MATCH_PARENT
            val height = ViewGroup.LayoutParams.MATCH_PARENT
            setLayout(width, height)
            setWindowAnimations(R.style.FullScreenDialog_Slide)
        }
    }

    private fun dismissDialog() {
        if (this.dialog?.isShowing == true) {
            dismiss()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGalleryDialogBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            closeButton.setOnClickListener {
                dismissDialog()
            }
            openButton.setOnClickListener {
                //Close all dialog and go To Notifications
                //findNavController().popBackStack(R.id.navigation_gallery_details, true)
                val navController =
                    requireActivity().findNavController(R.id.nav_host_fragment_activity_main)
                //navController.navigate(R.id.navigation_home)
                navController.popBackStack(R.id.navigation_gallery_details, true)
                navController.navigate(R.id.navigation_notifications)

            }
        }
    }

}