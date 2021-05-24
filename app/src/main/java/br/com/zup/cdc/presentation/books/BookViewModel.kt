package br.com.zup.cdc.presentation.books

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.zup.cdc.CoroutineContextProvider
import br.com.zup.cdc.domain.usecases.SearchBookUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class BookViewModel @Inject constructor(
    private val searchBookUseCase: SearchBookUseCase,
    private val contextProvider: CoroutineContextProvider
) :
    ViewModel() {

    private val handler = CoroutineExceptionHandler { _, throwable ->
        _books.postValue(BookState.Failure(throwable))
    }

    private val _books = MutableLiveData<BookState>()

    fun getBooksState() = _books as LiveData<BookState>

    fun fetchBooks() {
        viewModelScope.launch(handler) {
            _books.postValue(BookState.Loading)
            val books = withContext(contextProvider.IO) {
                searchBookUseCase.search()
            }
            _books.postValue(BookState.Success(books))
        }
    }
}
