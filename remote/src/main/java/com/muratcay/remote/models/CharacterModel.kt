package com.muratcay.remote.models

import kotlinx.serialization.SerialName

data class CharacterModel(
    val created: String,
    val gender: String,
    val id: Int,
    val image: String,
    @SerialName("location")
    val characterLocation: CharacterLocationModel,
    val name: String,
    val species: String,
    val status: String,
    val type: String,
    val url: String,
    var isBookMarked: Boolean = false
)