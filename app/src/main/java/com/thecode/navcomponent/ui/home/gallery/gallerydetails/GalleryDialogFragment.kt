package com.thecode.navcomponent.ui.home.gallery.gallerydetails

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import com.thecode.navcomponent.NavigationManager
import com.thecode.navcomponent.R
import com.thecode.navcomponent.databinding.FragmentGalleryDialogBinding


class GalleryDialogFragment : DialogFragment() {

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

    fun showDialog(manager: FragmentManager, tag: String?) {
        if (manager.findFragmentByTag(tag) != null) {
            Log.d("Dialog", "fragment already in the stack")
        } else {
            if (!manager.isStateSaved) {
                super.show(manager, tag)
            } else {
                Log.d("Dialog", "fragment already in the stack")
            }
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
                NavigationManager().goToGalleryDialog2(this@GalleryDialogFragment)
//                findNavController().navigate(
//                    R.id.action_galleryDialogFragment_to_galleryDialog2Fragment)
            }
        }
    }

}