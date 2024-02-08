package com.muratcay.presentation.character_detail

import androidx.lifecycle.viewModelScope
import androidx.lifecycle.SavedStateHandle
import com.muratcay.domain.Result
import com.muratcay.domain.usecase.GetCharacterByIdUseCase
import com.muratcay.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterDetailViewModel @Inject constructor(
    private val getCharacterByIdBaseUseCase: GetCharacterByIdUseCase,
    savedStateHandle: SavedStateHandle
) : BaseViewModel<CharacterDetailState>() {

    override fun setInitialState(): CharacterDetailState = CharacterDetailState.Loading

    init {
        savedStateHandle.get<Long>("characterId")?.takeIf { it > 0 }?.let { id ->
            fetchCharacterById(id)
        }
    }

    private fun fetchCharacterById(id: Long) {
        viewModelScope.launch {
            getCharacterByIdBaseUseCase.invoke(id).collect { result ->
                when (result) {
                    is Result.Success -> {
                        setState(
                            CharacterDetailState.Success(
                                result.data ?: throw IllegalStateException("Character not found")
                            )
                        )
                    }

                    is Result.Loading -> {
                        setState(CharacterDetailState.Loading)
                    }

                    is Result.Error -> {
                        setState(
                            CharacterDetailState.Error(
                                result.error
                                    ?: throw IllegalStateException("Error fetching character")
                            )
                        )
                    }
                }
            }
        }
    }

}