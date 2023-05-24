package com.thecode.navcomponent.ui.dashboard.dashboarddetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.thecode.navcomponent.NavigationManager.Companion.ITEM_ID
import com.thecode.navcomponent.databinding.FragmentDashboardDetailsBinding

class DashboardDetailsFragment : Fragment() {

    private var itemId: String? = null
    private var _binding: FragmentDashboardDetailsBinding? = null


    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            itemId = it.getString(ITEM_ID)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentDashboardDetailsBinding.inflate(inflater, container, false)

        binding.openButton.setOnClickListener {
            //val bundle = bundleOf("itemId" to itemId)
            //Navigation.findNavController(root).navigate(R.id.action_navigation_dashboard_to_navigation_details, bundle)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.textDetails.text = itemId
    }

    companion object {

        fun newInstance(itemId: String) =
            DashboardDetailsFragment().apply {
                val bundle = bundleOf(ITEM_ID to itemId)
                arguments = bundle
            }
    }
}