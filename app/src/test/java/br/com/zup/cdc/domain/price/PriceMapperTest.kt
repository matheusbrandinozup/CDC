package br.com.zup.cdc.domain.price

import br.com.zup.cdc.data.network.entity.BookType
import br.com.zup.cdc.data.network.entity.PriceResponse
import org.junit.Assert
import org.junit.Test
import java.math.BigDecimal

class PriceMapperTest {

    @Test
    fun `should map the api response to domain object`() {
        val mapper = PriceMapper()
        val pricesToConvert = arrayListOf(
            PriceResponse(29.9, BookType.EBOOK),
            PriceResponse(39.9, BookType.HARDCOVER),
            PriceResponse(59.9, BookType.COMBO)
        )
        val prices = mapper.map(pricesToConvert)

        Assert.assertEquals(3, prices.size)
        assertThat(price = prices[0], hasAmount = 29.90, andType = BookType.EBOOK)
        assertThat(price = prices[1], hasAmount = 39.90, andType = BookType.HARDCOVER)
        assertThat(price = prices[2], hasAmount = 59.90, andType = BookType.COMBO)
    }

    private fun assertThat(price: Price, hasAmount: Double, andType: BookType) {
        Assert.assertEquals(BigDecimal.valueOf(hasAmount), price.amount)
        Assert.assertEquals(andType, price.type)
    }
}