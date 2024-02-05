package com.muratcay.domain.usecase

import com.muratcay.domain.Result
import com.muratcay.domain.models.Character
import com.muratcay.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

typealias GetBookmarkCharacterListBaseUseCase = BaseUseCase<Unit, Flow<Result<List<Character>>>>

class GetBookmarkCharacterListUseCase @Inject constructor(
    private val characterRepository: CharacterRepository
) : GetBookmarkCharacterListBaseUseCase {

    override suspend operator fun invoke(params: Unit) = characterRepository.getBookMarkedCharacters()
}