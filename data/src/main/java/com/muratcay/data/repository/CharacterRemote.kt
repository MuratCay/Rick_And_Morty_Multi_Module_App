package com.muratcay.data.repository

import com.muratcay.data.models.CharacterEntity

interface CharacterRemote {
    suspend fun getCharacters(): List<CharacterEntity>
    suspend fun getCharacter(characterId: Long): CharacterEntity
}