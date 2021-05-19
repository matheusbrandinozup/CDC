package br.com.zup.cdc.domain

import br.com.zup.cdc.data.BookRepository
import javax.inject.Inject

class SearchBookUseCase @Inject constructor(private val repository: BookRepository, private val mapper : BookMapper) {

    suspend fun search() : ArrayList<Book>{
        val books = repository.search()
        val map = mapper.map(books)
        return map
    }
}