package br.com.zup.cdc.domain

import br.com.zup.cdc.data.network.entity.BookResponse
import javax.inject.Inject

class BookMapper @Inject constructor(){

    fun map(books: ArrayList<BookResponse>): ArrayList<Book> {
        return books.map { map(it) } as ArrayList<Book>
    }

    private fun map(dto: BookResponse): Book {
        return Book()
    }
}