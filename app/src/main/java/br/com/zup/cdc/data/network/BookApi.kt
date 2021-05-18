package br.com.zup.cdc.data.network

import br.com.zup.cdc.data.network.entity.BookResponse
import retrofit2.Retrofit
import retrofit2.http.GET
import javax.inject.Inject

class BookApi @Inject constructor(retrofit: Retrofit) {

    private val service = retrofit.create(BookService::class.java)

    suspend fun getBooks() = service.getBooks()

    private interface BookService {

        @GET("/api/book")
        suspend fun getBooks(): List<BookResponse>
    }
}