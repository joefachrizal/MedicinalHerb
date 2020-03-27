package com.android.medicinal.herb.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
Written by Muhammad Joe Fachrizal
 **/
@Parcelize
data class Herb(
    var name: String = "",
    var desc: String = "",
    var image: String = "",
    var detail: String =""
) : Parcelable