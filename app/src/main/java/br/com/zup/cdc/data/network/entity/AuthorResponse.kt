package br.com.zup.cdc.data.network.entity

import com.google.gson.annotations.SerializedName

class AuthorResponse(
    val id: Int,
    val bio: String,
    val firstName: String,
    val lastName: String,
    @field:SerializedName("profilePicturePath") val pictureUrl: String,
    @field:SerializedName("publishedBooks") val booksPublisheds: Int,
    @field:SerializedName("technologiesSHeWritesAbout") val techWritten: List<String>
)
