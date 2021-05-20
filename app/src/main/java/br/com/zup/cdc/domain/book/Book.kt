package br.com.zup.cdc.domain.book

import android.os.Parcelable
import br.com.zup.cdc.domain.price.Price
import br.com.zup.cdc.domain.author.Author
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

