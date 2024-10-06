package com.dicoding.eldenringwiki

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Remembrances(
    val id: String,
    val name: String,
    val description: String,
    val bossName: String,
    val image: Int,
    val rune: String,
    val weapon1: String,
    val weapon2: String
): Parcelable
