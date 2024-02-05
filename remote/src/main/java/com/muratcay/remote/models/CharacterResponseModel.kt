package com.muratcay.remote.models

import kotlinx.serialization.SerialName

data class CharacterResponseModel (
    @SerialName("results")
    val characters: List<CharacterModel>
)