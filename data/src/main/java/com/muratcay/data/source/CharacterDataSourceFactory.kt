package com.muratcay.data.source

import com.muratcay.data.repository.CharacterCache
import com.muratcay.data.repository.CharacterDataSource
import javax.inject.Inject

open class CharacterDataSourceFactory @Inject constructor(
    private val characterCache: CharacterCache,
    private val cacheDataSource: CharacterCacheDataSource,
    private val remoteDataSource: CharacterRemoteDataSource
) {

    open suspend fun getDataStore(isCached: Boolean): CharacterDataSource {
        return if (isCached && !characterCache.isExpired()) {
            return getCacheDataSource()
        } else {
            getRemoteDataSource()
        }
    }

    fun getRemoteDataSource(): CharacterDataSource {
        return remoteDataSource
    }

    fun getCacheDataSource(): CharacterDataSource {
        return cacheDataSource
    }
}