package br.com.zup.cdc.domain

import br.com.zup.cdc.data.network.entity.PriceResponse
import java.math.BigDecimal
import javax.inject.Inject

class PriceMapper @Inject constructor() {

    fun map(prices: List<PriceResponse>): ArrayList<Price> {
        return prices.map { map(it) } as ArrayList<Price>
    }

    private fun map(price: PriceResponse): Price {
        return Price(
            BigDecimal.valueOf(price.value),
            price.type
        )
    }
}