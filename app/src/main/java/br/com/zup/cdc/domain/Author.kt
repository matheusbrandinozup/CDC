package br.com.zup.cdc.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Author(
    val name: String,
    val picture: String,
    val description: String
) : Parcelable
