package com.muratcay.remote.mappers

import com.muratcay.data.models.CharacterLocationEntity
import com.muratcay.remote.models.CharacterLocationModel
import javax.inject.Inject

class CharacterLocationEntityMapper @Inject constructor() :
    EntityMapper<CharacterLocationModel, CharacterLocationEntity> {
    override fun mapFromModel(model: CharacterLocationModel): CharacterLocationEntity {
        return CharacterLocationEntity(name = model.name, url = model.url, id = 0)
    }
}