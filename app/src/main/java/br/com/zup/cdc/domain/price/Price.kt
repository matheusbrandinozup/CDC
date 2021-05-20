package br.com.zup.cdc.domain.price

import android.os.Parcelable
import br.com.zup.cdc.data.network.entity.BookType
import kotlinx.parcelize.Parcelize
import java.math.BigDecimal

@Parcelize
class Price(
    val amount : BigDecimal,
    val type : BookType
) : Parcelable
