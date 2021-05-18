package br.com.zup.cdc.data.network

import br.com.zup.cdc.data.network.entity.AuthorResponse
import retrofit2.Retrofit
import retrofit2.http.GET
import javax.inject.Inject

class AuthorApi @Inject constructor(retrofit: Retrofit) {

    private val service = retrofit.create(AuthorService::class.java)

    suspend fun getAuthors() = service.getAuthors()

    private interface AuthorService {

        @GET("/api/author")
        suspend fun getAuthors(): List<AuthorResponse>
    }
}