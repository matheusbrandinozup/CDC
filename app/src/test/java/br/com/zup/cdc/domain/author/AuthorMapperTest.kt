package br.com.zup.cdc.domain.author

import br.com.zup.cdc.data.network.entity.AuthorResponse
import org.junit.Assert
import org.junit.Test

class AuthorMapperTest {

    @Test
    fun `should map the api response to domain object`() {
        val authorMapper = AuthorMapper()
        val author = authorMapper.map(
            AuthorResponse(
                firstName = "Matheus",
                lastName = "Brandino",
                bio = "uma bio",
                booksPublisheds = 0,
                id = 0,
                pictureUrl = "url",
                techWritten = arrayListOf()
            )
        )

        Assert.assertEquals("Matheus Brandino", author.name)
        Assert.assertEquals("url", author.picture)
        Assert.assertEquals("uma bio", author.description)
    }
}