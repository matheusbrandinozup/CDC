package br.com.zup.cdc.presentation.books

import br.com.zup.cdc.domain.book.Book

sealed class BookState {
    object Loading : BookState()
    data class Success(val data: ArrayList<Book>) : BookState()
    data class Failure(val data: String) : BookState()
}
