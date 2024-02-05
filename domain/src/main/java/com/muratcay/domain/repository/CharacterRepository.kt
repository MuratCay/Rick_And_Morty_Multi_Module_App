package com.muratcay.domain.repository

import com.muratcay.domain.Result
import com.muratcay.domain.models.Character
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {

    // Remote and cache
    suspend fun getCharacters(): Flow<Result<List<Character>>>
    suspend fun getCharacter(characterId: Long): Flow<Result<Character>>
    // Cache
    suspend fun saveCharacters(listCharacters: List<Character>)
    suspend fun getBookMarkedCharacters(): Flow<Result<List<Character>>>
    suspend fun setCharacterBookmarked(characterId: Long): Flow<Int>
    suspend fun setCharacterUnBookMarked(characterId: Long): Flow<Int>
}