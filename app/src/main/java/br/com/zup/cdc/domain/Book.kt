package br.com.zup.cdc.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Book(
    val title: String,
    val subtitle: String,
    val author: Author,
    val imageUrl: String,
    val prices: ArrayList<Price>,
    val description: String
) : Parcelable

