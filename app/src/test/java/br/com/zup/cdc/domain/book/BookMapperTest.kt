package br.com.zup.cdc.domain.book

import br.com.zup.cdc.data.network.entity.AuthorResponse
import br.com.zup.cdc.data.network.entity.BookResponse
import br.com.zup.cdc.data.network.entity.BookType
import br.com.zup.cdc.data.network.entity.PriceResponse
import br.com.zup.cdc.domain.author.AuthorMapper
import br.com.zup.cdc.domain.price.PriceMapper
import org.junit.Assert
import org.junit.Test

class BookMapperTest {

    @Test
    fun `should map the api response to domain object`() {
        val mapper = BookMapper(AuthorMapper(), PriceMapper())
        val books = mapper.map(booksResponses())

        Assert.assertEquals(2, books.size)
        assertThat(
            book = books[0],
            hasTitle = "Livro 1",
            hasSubtitle = "Sub do livro 1",
            hasDescription = "bio do livro 1",
            hasUrl = "url do livro 1"
        )
        assertThat(
            book = books[1],
            hasTitle = "Livro 2",
            hasSubtitle = "Sub do livro 2",
            hasDescription = "bio do livro 2",
            hasUrl = "url do livro 2"
        )
    }

    private fun assertThat(
        book: Book,
        hasTitle: String,
        hasSubtitle: String,
        hasDescription: String,
        hasUrl: String
    ) {
        Assert.assertEquals(hasTitle, book.title)
        Assert.assertEquals(hasSubtitle, book.subtitle)
        Assert.assertEquals(hasDescription, book.description)
        Assert.assertEquals(hasUrl, book.imageUrl)

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