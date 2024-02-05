package com.muratcay.data.mapper

import com.muratcay.data.models.CharacterLocationEntity
import com.muratcay.domain.models.CharacterLocation
import javax.inject.Inject

class CharacterLocationMapper @Inject constructor() : Mapper<CharacterLocationEntity, CharacterLocation> {

    override fun mapFromEntity(type: CharacterLocationEntity): CharacterLocation {
        return CharacterLocation(name = type.name, url = type.url)
    }

    override fun mapToEntity(type: CharacterLocation): CharacterLocationEntity {
        return CharacterLocationEntity(name = type.name, url = type.url, id = 0)
    }
}