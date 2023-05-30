package com.thecode.navcomponent

import android.app.Activity
import android.content.Intent
import android.view.View
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import com.thecode.navcomponent.ui.checkout.CheckoutActivity


class NavigationManager {

    fun goToGalleryDetails(view: View, albumId: String) {
        val bundle = bundleOf(ALBUM_ID to albumId)
        Navigation.findNavController(view).navigate(R.id.action_galleryFragment_to_galleryDetailsFragment, bundle)
    }

    fun goToDashboardDetails(view: View, itemId: String) {
        val bundle = bundleOf(ITEM_ID to itemId)
        Navigation.findNavController(view).navigate(R.id.action_dashboardFragment_to_dashboardDetailsFragment, bundle)
    }

    fun goToCheckoutActivity(activity: Activity) {
        val intent = Intent(activity, CheckoutActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        activity.startActivity(intent)
    }

    fun goToPlaceOrder(view: View) {
        Navigation.findNavController(view).navigate(R.id.action_orderFragment_to_uploadFragment)
    }

    fun goToSelectStore(view: View) {
        Navigation.findNavController(view).navigate(R.id.action_orderFragment_to_selectStoreFragment)
    }


    companion object {
        const val ALBUM_ID = "albumId"
        const val ITEM_ID = "itemId"
        private const val PRODUCT_ID = "productId"
        private const val CATALOG_PRODUCT_ID = "catalogProductId"
    }
}


