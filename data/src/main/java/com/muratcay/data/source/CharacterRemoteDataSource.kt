package com.muratcay.data.source

import com.muratcay.data.models.CharacterEntity
import com.muratcay.data.repository.CharacterDataSource
import com.muratcay.data.repository.CharacterRemote
import javax.inject.Inject

class CharacterRemoteDataSource @Inject constructor(
    private val characterRemote: CharacterRemote
) : CharacterDataSource {

    override suspend fun getCharacters(): List<CharacterEntity> {
        return characterRemote.getCharacters()
    }

    override suspend fun getCharacter(characterId: Long): CharacterEntity {
        return characterRemote.getCharacter(characterId)
    }

    override suspend fun saveCharacters(listCharacters: List<CharacterEntity>) {
        throw UnsupportedOperationException("Save character is not supported for RemoteDataSource.")
    }

    override suspend fun getBookMarkedCharacters(): List<CharacterEntity> {
        throw UnsupportedOperationException("Get bookmark characters is not supported for RemoteDataSource.")
    }

    override suspend fun setCharacterBookmarked(characterId: Long): Int {
        throw UnsupportedOperationException("Set bookmark character is not supported for RemoteDataSource.")
    }

    override suspend fun setCharacterUnBookMarked(characterId: Long): Int {
        throw UnsupportedOperationException("Set UnBookmark characters is not supported for RemoteDataSource.")
    }

    override suspend fun isCached(): Boolean {
        throw UnsupportedOperationException("Cache is not supported for RemoteDataSource.")
    }
}