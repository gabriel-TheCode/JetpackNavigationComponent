package com.thecode.navcomponent

import android.view.View
import androidx.core.os.bundleOf
import androidx.navigation.Navigation


class NavigationManager {

    fun goToGalleryDetails(view: View, albumId: String) {
        val bundle = bundleOf(ALBUM_ID to albumId)
        Navigation.findNavController(view).navigate(R.id.action_galleryFragment_to_galleryDetailsFragment, bundle)
    }

    fun goToDashboardDetails(view: View, itemId: String) {
        val bundle = bundleOf(ITEM_ID to itemId)
        Navigation.findNavController(view).navigate(R.id.action_navigation_dashboard_to_navigation_details, bundle)
    }


    companion object {
        const val ALBUM_ID = "albumId"
        const val ITEM_ID = "itemId"
        private const val PRODUCT_ID = "productId"
        private const val CATALOG_PRODUCT_ID = "catalogProductId"
    }
}


