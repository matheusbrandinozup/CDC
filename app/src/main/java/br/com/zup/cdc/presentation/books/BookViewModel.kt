package br.com.zup.cdc.presentation.books

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.zup.cdc.domain.SearchBookUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookViewModel @Inject constructor(private val searchBookUseCase: SearchBookUseCase) :
    ViewModel() {

    private val _books = MutableLiveData<BookState>()

    fun getBooksState() = _books as LiveData<BookState>

    fun fetchBooks() {
        viewModelScope.launch(Dispatchers.IO) {
            _books.postValue(BookState.Loading)
            try {
                val books = searchBookUseCase.search()
                _books.postValue(BookState.Success(books))
            } catch (failure: Exception) {
                _books.postValue(BookState.Failure(failure.message.toString()))
            }
        }
    }
}
