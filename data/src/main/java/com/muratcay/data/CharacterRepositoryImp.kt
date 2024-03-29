package com.muratcay.data

import com.muratcay.data.mapper.CharacterMapper
import com.muratcay.data.source.CharacterDataSourceFactory
import com.muratcay.domain.Result
import com.muratcay.domain.repository.CharacterRepository
import com.muratcay.domain.models.Character
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CharacterRepositoryImp @Inject constructor(
    private val dataSourceFactory: CharacterDataSourceFactory,
    private val characterMapper: CharacterMapper
) : CharacterRepository {

    override suspend fun getCharacters(): Flow<Result<List<Character>>> = flow {
        val isCached = dataSourceFactory.getCacheDataSource().isCached()
        val characterList =
            dataSourceFactory.getDataStore(isCached).getCharacters().map { characterEntity ->
                characterMapper.mapFromEntity(characterEntity)
            }
        saveCharacters(characterList)
        emit(Result.Success(characterList))
    }

    override suspend fun getCharacter(characterId: Long): Flow<Result<Character>> = flow {
        var character = dataSourceFactory.getCacheDataSource().getCharacter(characterId)
        if (character.image.isEmpty()) {
            character = dataSourceFactory.getRemoteDataSource().getCharacter(characterId)
        }
        emit(Result.Success(characterMapper.mapFromEntity(character)))
    }

    override suspend fun saveCharacters(listCharacters: List<Character>) {
        val characterEntities = listCharacters.map { character ->
            characterMapper.mapToEntity(character)
        }
        dataSourceFactory.getCacheDataSource().saveCharacters(characterEntities)
    }

    override suspend fun getBookMarkedCharacters(): Flow<Result<List<Character>>> = flow {
        val characterList = dataSourceFactory.getCacheDataSource().getBookMarkedCharacters()
            .map { characterEntity ->
                characterMapper.mapFromEntity(characterEntity)
            }
        emit(Result.Success(characterList))
    }

    override suspend fun setCharacterBookmarked(characterId: Long): Flow<Int> = flow {
        emit(dataSourceFactory.getCacheDataSource().setCharacterBookmarked(characterId))
    }

    override suspend fun setCharacterUnBookMarked(characterId: Long): Flow<Int> = flow {
        emit(dataSourceFactory.getCacheDataSource().setCharacterUnBookMarked(characterId))
    }
}