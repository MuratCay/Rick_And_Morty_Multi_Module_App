package com.muratcay.domain.usecase

import com.muratcay.domain.Result
import kotlinx.coroutines.flow.Flow
import com.muratcay.domain.models.Character
import com.muratcay.domain.repository.CharacterRepository
import javax.inject.Inject

typealias GetCharacterListBaseUseCase = BaseUseCase<Unit, Flow<Result<List<Character>>>>

class GetCharacterListUseCase @Inject constructor(
    private val characterRepository: CharacterRepository
) : GetCharacterListBaseUseCase {

    override suspend operator fun invoke(params: Unit) = characterRepository.getCharacters()
}