package com.thecode.navcomponent.ui.checkout.upload

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.thecode.navcomponent.databinding.FragmentUploadBinding

class UploadFragment : Fragment() {

    companion object {
        fun newInstance() = UploadFragment()
    }

    private var _binding: FragmentUploadBinding? = null

    private val binding get() = _binding!!

    private lateinit var viewModel: UploadViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUploadBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[UploadViewModel::class.java]
        binding.cancelButton.apply {
            findNavController().popBackStack()
        }
    }
}