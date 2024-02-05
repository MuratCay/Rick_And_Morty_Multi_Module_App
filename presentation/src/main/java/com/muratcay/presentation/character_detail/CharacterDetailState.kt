package com.muratcay.presentation.character_detail

import com.muratcay.domain.models.Character
import com.muratcay.presentation.base.IState

interface CharacterDetailState : IState {
    data object Loading : CharacterDetailState
    data class Success(val character: Character) : CharacterDetailState
    data class Error(val error: Exception) : CharacterDetailState
}