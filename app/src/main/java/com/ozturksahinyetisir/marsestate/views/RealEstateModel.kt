package com.ozturksahinyetisir.marsestate.views

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
/**
 * Get data from Api and parcelize it.
 */
data class RealEstateModel(

    val price: Int,
    val id: String?=null,
    val type: String,
    val img_src: String
): Parcelable