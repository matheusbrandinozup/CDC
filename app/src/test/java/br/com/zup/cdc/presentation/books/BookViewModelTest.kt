package br.com.zup.cdc.presentation.books

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import br.com.zup.cdc.data.network.entity.BookType
import br.com.zup.cdc.domain.author.Author
import br.com.zup.cdc.domain.book.Book
import br.com.zup.cdc.domain.price.Price
import br.com.zup.cdc.domain.usecases.SearchBookUseCase
import br.com.zup.cdc.presentation.books.BookState.*
import br.com.zup.cdc.util.TestCoroutineContextProvider
import br.com.zup.cdc.util.TestCoroutineRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.whenever
import java.math.BigDecimal

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class BookViewModelTest {

    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    @Mock
    lateinit var observer: Observer<BookState>

    @Mock
    lateinit var useCase: SearchBookUseCase

    private lateinit var viewModel: BookViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        viewModel = BookViewModel(useCase, TestCoroutineContextProvider())
        viewModel.getBooksState().observeForever(observer)
    }

    @After
    fun tearDown() {
        viewModel.getBooksState().removeObserver(observer)
    }

    @Test
    fun `should emits the loading and after the error states when some error occurs`() {
        testCoroutineRule.runBlockingTest {
            val error = Error()
            whenever(useCase.search()).thenThrow(error)

            viewModel.fetchBooks()

            verify(observer).onChanged(Loading)
            verify(useCase).search()
            verify(observer).onChanged(Failure(error))
        }
    }


    @Test
    fun `should emits the loading and after the success states without error `() {
        testCoroutineRule.runBlockingTest {
            val books = getList()
            doReturn(books).whenever(useCase).search()

            viewModel.fetchBooks()

            verify(observer).onChanged(Loading)
            verify(useCase).search()
            verify(observer).onChanged(Success(books))
        }
    }

    private fun getList(): ArrayList<Book> {
        return arrayListOf(
            Book(
                title = "livro",
                description = "description",
                subtitle = "sub",
                imageUrl = "url",
                author = Author(description = "bio", picture = "url", name = "eu"),
                prices = arrayListOf(
                    Price(BigDecimal.ZERO, BookType.EBOOK)
                )
            )
        )
    }
}