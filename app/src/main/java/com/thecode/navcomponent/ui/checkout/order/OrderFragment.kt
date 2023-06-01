package com.thecode.navcomponent.ui.checkout.order

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.thecode.navcomponent.NavigationManager
import com.thecode.navcomponent.databinding.FragmentOrderBinding
import com.thecode.navcomponent.ui.home.gallery.GalleryViewModel

class OrderFragment : Fragment() {

    companion object {
        fun newInstance() = OrderFragment()
    }


    private var _binding: FragmentOrderBinding? = null

    private val binding get() = _binding!!


    private lateinit var viewModel: OrderViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOrderBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[OrderViewModel::class.java]

        binding.apply {
            placeOrderButton.setOnClickListener {
                NavigationManager().goToUpload(root)
            }

            selectStoreButton.setOnClickListener {
                NavigationManager().goToSelectStore(root)
            }
        }

    }

}