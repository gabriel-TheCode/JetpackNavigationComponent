package com.thecode.navcomponent.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.thecode.navcomponent.NavigationManager
import com.thecode.navcomponent.databinding.FragmentDashboardBinding
import com.thecode.navcomponent.ui.dashboard.dashboarddetails.DashboardDetailsViewModel

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    private val binding get() = _binding!!
    private lateinit var itemId: String

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dashboardViewModel =
            ViewModelProvider(this)[DashboardDetailsViewModel::class.java]

        binding.apply {
            dashboardViewModel.text.observe(viewLifecycleOwner) {
                textDashboard.text = it
                itemId = "Dashboard Details Fragment"
            }

            openButton.setOnClickListener {
                NavigationManager().goToDashboardDetails(root, itemId)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}