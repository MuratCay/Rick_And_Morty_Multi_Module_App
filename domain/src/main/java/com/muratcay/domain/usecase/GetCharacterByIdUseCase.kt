package com.muratcay.domain.usecase

import com.muratcay.domain.Result
import com.muratcay.domain.models.Character
import com.muratcay.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

typealias GetCharacterByIdBaseUseCase = BaseUseCase<Long, Flow<Result<Character>>>

class GetCharacterByIdUseCase @Inject constructor(
    private val characterRepository: CharacterRepository
) : GetCharacterByIdBaseUseCase {

    override suspend operator fun invoke(params: Long) = characterRepository.getCharacter(params)
}