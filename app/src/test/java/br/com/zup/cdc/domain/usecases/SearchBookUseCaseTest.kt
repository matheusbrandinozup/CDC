package br.com.zup.cdc.domain.usecases

import br.com.zup.cdc.data.BookRepository
import br.com.zup.cdc.data.network.entity.AuthorResponse
import br.com.zup.cdc.data.network.entity.BookResponse
import br.com.zup.cdc.data.network.entity.BookType
import br.com.zup.cdc.data.network.entity.PriceResponse
import br.com.zup.cdc.domain.author.AuthorMapper
import br.com.zup.cdc.domain.book.BookMapper
import br.com.zup.cdc.domain.price.PriceMapper
import br.com.zup.cdc.util.TestCoroutineRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.whenever

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class SearchBookUseCaseTest {

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    private lateinit var useCase: SearchBookUseCase

    @Mock
    lateinit var repository: BookRepository

    @Before
    fun setUp() {
        val mapper = BookMapper(AuthorMapper(), PriceMapper())
        useCase = SearchBookUseCase(repository, mapper)
    }

    @Test
    fun `should create a book list when the repository search is complete`() {
        testCoroutineRule.runBlockingTest {
            whenever(repository.search()).thenReturn(booksResponses())

            val books = useCase.search()

            assertEquals(2, books.size)
        }
    }

    @Test
    fun `should create a empty list when the repository search is complete but do not has value`() {
        testCoroutineRule.runBlockingTest {
            whenever(repository.search()).thenReturn(arrayListOf())

            val books = useCase.search()

            assertEquals(0, books.size)
        }
    }

    private fun booksResponses() = arrayListOf(
        BookResponse(
            title = "Livro 1",
            id = 0,
            description = "bio do livro 1",
            imageUrl = "url do livro 1",
            subtitle = "Sub do livro 1",
            pages = 10,
            isbn = "1234",
            publicationDate = "12/01/2020",
            prices = defaultPrices(),
            author = defaultAuthor()
        ),
        BookResponse(
            title = "Livro 2",
            id = 1,
            description = "bio do livro 2",
            imageUrl = "url do livro 2",
            subtitle = "Sub do livro 2",
            pages = 10,
            isbn = "12345",
            publicationDate = "12/01/2020",
            prices = defaultPrices(),
            author = defaultAuthor()
        )
    )

    private fun defaultPrices() = arrayListOf(
        PriceResponse(29.9, BookType.EBOOK),
        PriceResponse(39.9, BookType.HARDCOVER),
        PriceResponse(59.9, BookType.COMBO)
    )

    private fun defaultAuthor() = AuthorResponse(
        firstName = "Matheus",
        lastName = "Brandino",
        bio = "uma bio",
        booksPublisheds = 0,
        id = 0,
        pictureUrl = "url",
        techWritten = arrayListOf()
    )

}