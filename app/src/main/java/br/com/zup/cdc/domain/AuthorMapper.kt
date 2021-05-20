package br.com.zup.cdc.domain

import br.com.zup.cdc.data.network.entity.AuthorResponse
import javax.inject.Inject

class AuthorMapper @Inject constructor() {

    fun map(author: AuthorResponse): Author {
        return Author(
            name = "${author.firstName} ${author.lastName}",
            picture = author.pictureUrl,
            description = author.bio
        )
    }
}