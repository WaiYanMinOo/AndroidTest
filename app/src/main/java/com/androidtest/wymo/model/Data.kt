package com.androidtest.wymo.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Data(
    val bgColor: String,
    val centerColor: String,
    val created_at: String,
    val deleted_at: String,
    val description: String,
    val enabled: Int,
    val endColor: String,
    val fontColor: String,
    val id: Int,
    val instruction1: String,
    val instruction2: String,
    val is_major: Boolean,
    val length: Int,
    val logoThumbnail: String,
    val logoUrl: String,
    val logo_url: String,
    val maxAmount: String,
    val name: String,
    val startColor: String,
    val type: String,
    val updated_at: String
) : Parcelable