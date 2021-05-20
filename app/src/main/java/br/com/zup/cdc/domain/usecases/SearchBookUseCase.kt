package br.com.zup.cdc.domain.usecases

import br.com.zup.cdc.data.BookRepository
import br.com.zup.cdc.domain.book.Book
import br.com.zup.cdc.domain.book.BookMapper
import javax.inject.Inject

class SearchBookUseCase @Inject constructor(
    private val repository: BookRepository,
    private val mapper: BookMapper
) {

    suspend fun search(): ArrayList<Book> {
        val books = repository.search()
        return mapper.map(books)
    }
}