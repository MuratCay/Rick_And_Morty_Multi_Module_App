package com.muratcay.database.mapper

import com.muratcay.data.models.CharacterLocationEntity
import com.muratcay.database.models.CharacterLocationCacheEntity
import javax.inject.Inject

class CharacterLocationCacheMapper @Inject constructor() :
    CacheMapper<CharacterLocationCacheEntity, CharacterLocationEntity> {
    override fun mapFromCached(type: CharacterLocationCacheEntity): CharacterLocationEntity {
        return CharacterLocationEntity(name = type.name, url = type.url, id = 0)
    }

    override fun mapToCached(type: CharacterLocationEntity): CharacterLocationCacheEntity {
        return CharacterLocationCacheEntity(name = type.name, url = type.url)
    }
}