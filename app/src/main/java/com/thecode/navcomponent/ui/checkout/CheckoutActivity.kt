package com.thecode.navcomponent.ui.checkout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.thecode.navcomponent.R
import com.thecode.navcomponent.databinding.ActivityCheckoutBinding

class CheckoutActivity : AppCompatActivity() {

    private var _binding: ActivityCheckoutBinding? = null

    private lateinit var navController: NavController

    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_checkout)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_checkout) as NavHostFragment
        navController = navHostFragment.findNavController()
    }

}