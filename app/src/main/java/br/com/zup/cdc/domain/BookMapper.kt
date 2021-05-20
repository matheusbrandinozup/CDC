package br.com.zup.cdc.domain

import br.com.zup.cdc.data.network.entity.BookResponse
import java.math.BigDecimal
import javax.inject.Inject

class BookMapper @Inject constructor(
    private val authorMapper: AuthorMapper,
    private val priceMapper: PriceMapper
) {

    fun map(books: ArrayList<BookResponse>): ArrayList<Book> {
        return books.map { map(it) } as ArrayList<Book>
    }

    private fun map(dto: BookResponse): Book {
        return Book(
            title = dto.title,
            subtitle = dto.subtitle,
            author = authorMapper.map(dto.author),
            description = dto.description,
            imageUrl = dto.imageUrl,
            prices = priceMapper.map(dto.prices)
        )
    }
}