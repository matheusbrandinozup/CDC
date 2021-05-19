package br.com.zup.cdc.domain

import br.com.zup.cdc.data.network.entity.BookResponse
import java.math.BigDecimal
import javax.inject.Inject

class BookMapper @Inject constructor() {

    fun map(books: ArrayList<BookResponse>): ArrayList<Book> {
        return books.map { map(it) } as ArrayList<Book>
    }

    private fun map(dto: BookResponse): Book {
        return Book(
            title = dto.title,
            subtitle = dto.subtitle,
            Author(
                name = "${dto.author.firstName} ${dto.author.lastName}",
                picture = dto.author.pictureUrl,
                description = dto.author.bio
            ),
            description = dto.description,
            imageUrl = dto.imageUrl,
            prices = dto.prices.map {
                Price(
                    BigDecimal.valueOf(it.value),
                    it.type
                )
            } as ArrayList<Price>
        )
    }
}