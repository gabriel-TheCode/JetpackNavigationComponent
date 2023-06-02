package com.thecode.navcomponent

import android.app.Activity
import android.content.Intent
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.thecode.navcomponent.ui.checkout.CheckoutActivity


class NavigationManager {

    fun goToGalleryDetails(view: View, albumId: String) {
        val bundle = bundleOf(ALBUM_ID to albumId)
        Navigation.findNavController(view)
            .navigate(R.id.action_galleryFragment_to_galleryDetailsFragment, bundle)
    }

    fun goToDashboardDetails(view: View, itemId: String) {
        val bundle = bundleOf(ITEM_ID to itemId)
        Navigation.findNavController(view)
            .navigate(R.id.action_dashboardFragment_to_dashboardDetailsFragment, bundle)
    }

    fun goToCheckoutActivity(activity: Activity) {
        val intent = Intent(activity, CheckoutActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        activity.startActivity(intent)
    }

    fun goToUpload(view: View) {
        Navigation.findNavController(view).navigate(R.id.action_orderFragment_to_uploadFragment)
    }

    fun goToSelectStore(view: View) {
        Navigation.findNavController(view).navigate(
            R.id.action_orderFragment_to_selectStoreFragment
        )
    }

    fun goToGalleryDialog(view: View) {
        Navigation.findNavController(view).navigate(
            R.id.action_gallery_details_to_galleryDialogFragment
        )
    }

    fun goToGalleryDialog2(fragment: DialogFragment) {
        fragment.findNavController().navigate(
            R.id.action_galleryDialogFragment_to_galleryDialog2Fragment
        )
    }

    //Close all dialog and go To Notifications
    fun goToNotifications(activity: Activity) {
        val navController =
            activity.findNavController(R.id.nav_host_fragment_activity_main)
        navController.popBackStack(
            R.id.navigation_gallery_details,
            true
        ) // Go back to Gallery Details and close it (inclusive), so it's navigate to Gallery, can also be done like //navController.popBackStack(R.id.navigation_gallery, false)
        navController.navigate(R.id.action_home_to_notifications) // Move to Notifications
    }


    companion object {
        const val ALBUM_ID = "albumId"
        const val ITEM_ID = "itemId"
        private const val PRODUCT_ID = "productId"
        private const val CATALOG_PRODUCT_ID = "catalogProductId"
    }
}


