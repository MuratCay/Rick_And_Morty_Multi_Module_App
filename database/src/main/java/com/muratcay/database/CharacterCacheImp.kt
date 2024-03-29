package com.muratcay.database

import com.muratcay.data.models.CharacterEntity
import com.muratcay.data.repository.CharacterCache
import com.muratcay.database.dao.CharacterDao
import com.muratcay.database.mapper.CharacterCacheMapper
import com.muratcay.database.utils.CachePreferencesHelper
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CharacterCacheImp @Inject constructor(
    private val characterDao: CharacterDao,
    private val characterCacheMapper: CharacterCacheMapper,
    private val preferencesHelper: CachePreferencesHelper,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : CharacterCache {

    override suspend fun getCharacters(): List<CharacterEntity> = withContext(ioDispatcher) {
        return@withContext characterDao.getCharacters().map { cacheCharacter ->
            characterCacheMapper.mapFromCached(cacheCharacter)
        }
    }

    override suspend fun getCharacter(characterId: Long): CharacterEntity = withContext(ioDispatcher)  {
        return@withContext characterCacheMapper.mapFromCached(characterDao.getCharacter(characterId))
    }

    override suspend fun saveCharacters(listCharacters: List<CharacterEntity>) = withContext(ioDispatcher)  {
        characterDao.addCharacter(
            *listCharacters.map {
                characterCacheMapper.mapToCached(it)
            }.toTypedArray()
        )
    }

    override suspend fun getBookMarkedCharacters(): List<CharacterEntity> = withContext(ioDispatcher)  {
        return@withContext characterDao.getBookMarkedCharacters().map { cacheCharacter ->
            characterCacheMapper.mapFromCached(cacheCharacter)
        }
    }

    override suspend fun setCharacterBookmarked(characterId: Long): Int {
        return characterDao.bookmarkCharacter(characterId)
    }

    override suspend fun setCharacterUnBookMarked(characterId: Long): Int {
        return characterDao.unBookmarkCharacter(characterId)
    }

    override suspend fun isCached(): Boolean = withContext(ioDispatcher)  {
        return@withContext characterDao.getCharacters().isNotEmpty()
    }

    override suspend fun setLastCacheTime(lastCache: Long) {
        preferencesHelper.lastCacheTime = lastCache
    }

    override suspend fun isExpired(): Boolean {
        val currentTime = System.currentTimeMillis()
        val lastUpdateTime = getLastCacheUpdateTimeMillis()
        return currentTime - lastUpdateTime > EXPIRATION_TIME
    }

    /**
     * Get in millis, the last time the cache was accessed.
     */
    private fun getLastCacheUpdateTimeMillis(): Long {
        return preferencesHelper.lastCacheTime
    }

    companion object {
        /**
         * Expiration time set to 5 minutes
         */
        const val EXPIRATION_TIME = (60 * 5 * 1000).toLong()
    }
}