package com.thecode.navcomponent.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.thecode.navcomponent.NavigationManager
import com.thecode.navcomponent.databinding.FragmentDashboardBinding
import com.thecode.navcomponent.ui.dashboard.dashboarddetails.DashboardDetailsViewModel

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    private val binding get() = _binding!!
    private lateinit var itemId : String

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this)[DashboardDetailsViewModel::class.java]

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textDashboard
        dashboardViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
            itemId = "Dashboard Details Fragment"
        }

        binding.openButton.setOnClickListener {
            //val bundle = bundleOf(ITEM_ID to itemId)
            //Navigation.findNavController(root).navigate(R.id.action_navigation_dashboard_to_navigation_details, bundle)
            NavigationManager().goToDashboardDetails(root, itemId)
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}