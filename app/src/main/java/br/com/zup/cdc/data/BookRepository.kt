package br.com.zup.cdc.data

import br.com.zup.cdc.data.network.BookApi
import javax.inject.Inject

class BookRepository @Inject constructor(private val bookApi: BookApi) {
    suspend fun search() = bookApi.getBooks()

}
