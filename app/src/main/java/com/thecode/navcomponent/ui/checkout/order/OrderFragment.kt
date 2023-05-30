package com.thecode.navcomponent.ui.checkout.order

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.thecode.navcomponent.NavigationManager
import com.thecode.navcomponent.databinding.FragmentOrderBinding

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
    ): View? {
        _binding = FragmentOrderBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            openButton.setOnClickListener {
                NavigationManager().goToPlaceOrder(root)
            }

            selectStoreButton.setOnClickListener {
                NavigationManager().goToSelectStore(root)
            }
        }

    }

}