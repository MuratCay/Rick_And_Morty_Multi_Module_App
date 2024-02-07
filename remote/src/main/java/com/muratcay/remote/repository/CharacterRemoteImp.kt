package com.muratcay.remote.repository

import com.muratcay.data.models.CharacterEntity
import com.muratcay.data.repository.CharacterRemote
import com.muratcay.remote.api.CharacterService
import com.muratcay.remote.mappers.CharacterEntityMapper
import javax.inject.Inject

class CharacterRemoteImp @Inject constructor(
    private val characterService: CharacterService,
    private val characterEntityMapper: CharacterEntityMapper
) : CharacterRemote {

    override suspend fun getCharacters(): List<CharacterEntity> {
        val characters = characterService.getCharacters().results
        return characters.map { characterModel ->
            characterEntityMapper.mapFromModel(characterModel)
        } ?: emptyList()
    }


    override suspend fun getCharacter(characterId: Long): CharacterEntity {
        return characterEntityMapper.mapFromModel(characterService.getCharacter(characterId))
    }
}