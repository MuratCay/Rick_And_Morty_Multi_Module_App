package com.muratcay.presentation.chacaterlist

import androidx.lifecycle.viewModelScope
import com.muratcay.domain.usecase.GetCharacterListUseCase
import com.muratcay.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.muratcay.domain.Result
import com.muratcay.domain.usecase.GetBookmarkCharacterListUseCase

@HiltViewModel
class CharacterListViewModel @Inject constructor(
    private val getCharacterListUseCase: GetCharacterListUseCase,
    private val getBookmarkCharacterListUseCase: GetBookmarkCharacterListUseCase
) : BaseViewModel<CharacterListState>() {

    override fun setInitialState(): CharacterListState = CharacterListState.Loading

    init {
        getFavoriteCharacters()
    }

     fun fetchCharacters() {
        viewModelScope.launch {
            getCharacterListUseCase.invoke(Unit).collect { result ->
                when (result) {
                    is Result.Success -> {
                        setState(CharacterListState.Success(result.data))
                    }
                    is Result.Loading -> {
                        setState(CharacterListState.Loading)
                    }
                    is Result.Error -> {
                        setState(CharacterListState.Error(result.error))
                    }
                }
            }
        }
    }

    private fun getFavoriteCharacters() {
        viewModelScope.launch {
            getBookmarkCharacterListUseCase.invoke(Unit).collect { result ->
                when (result) {
                    is Result.Success -> {
                        setState(CharacterListState.Success(result.data))
                    }
                    is Result.Loading -> {
                        setState(CharacterListState.Loading)
                    }
                    is Result.Error -> {
                        setState(CharacterListState.Error(result.error))
                    }
                }
            }
        }
    }
}