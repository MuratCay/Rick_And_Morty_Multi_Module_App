package com.muratcay.remote.api

import com.muratcay.remote.models.CharacterModel
import com.muratcay.remote.models.CharacterResponseModel
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CharacterService {

    @GET("character")
    suspend fun getCharacters(): CharacterResponseModel

    @GET("character/{id}")
    suspend fun getCharacter(@Path("id") id: Long): CharacterModel
}