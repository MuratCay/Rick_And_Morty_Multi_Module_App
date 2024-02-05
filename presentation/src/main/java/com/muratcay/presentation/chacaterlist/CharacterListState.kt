package com.muratcay.presentation.chacaterlist

import com.muratcay.domain.models.Character
import com.muratcay.presentation.base.IState

sealed interface CharacterListState : IState {
    data object Loading : CharacterListState
    data class Success(val characters: List<Character>?) : CharacterListState
    data class Error(val error: Exception?) : CharacterListState
}