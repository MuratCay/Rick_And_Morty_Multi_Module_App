package com.muratcay.remote.mappers

import com.muratcay.data.models.CharacterEntity
import com.muratcay.remote.models.CharacterModel
import javax.inject.Inject

class CharacterEntityMapper @Inject constructor(
    private val characterLocationEntityMapper: CharacterLocationEntityMapper
) : EntityMapper<CharacterModel, CharacterEntity> {
    override fun mapFromModel(model: CharacterModel): CharacterEntity {
        return CharacterEntity(
            created = model.created,
            gender = model.gender,
            id = model.id,
            image = model.image,
            characterLocation = characterLocationEntityMapper.mapFromModel(model.location),
            name = model.name,
            species = model.species,
            status = model.status,
            type = model.type,
            url = model.url,
            isBookMarked = model.isBookMarked
        )
    }
}