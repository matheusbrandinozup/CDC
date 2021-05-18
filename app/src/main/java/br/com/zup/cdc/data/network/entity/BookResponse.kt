package br.com.zup.cdc.data.network.entity

import com.google.gson.annotations.SerializedName

class BookResponse(
    val id: Int,
    val title: String,
    val subtitle: String,
    val description: String,
    @field:SerializedName("coverImagePath") val imageUrl: String,
    val publicationDate: String,
    val isbn: Int,
    @field:SerializedName("numberOfPages") val pages: Int,
    val author: AuthorResponse,
    val prices: List<PriceResponse>
)

class PriceResponse(val value: Double, val type: BookType)

enum class BookType {
    COMBO, EBOOK, HARDCOVER
}