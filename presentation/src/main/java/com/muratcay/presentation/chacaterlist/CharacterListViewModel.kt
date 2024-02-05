package com.muratcay.presentation.chacaterlist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.muratcay.domain.models.Character
import com.muratcay.domain.usecase.GetCharacterListUseCase
import com.muratcay.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterListViewModel @Inject constructor(
    private val getCharacterListUseCase: GetCharacterListUseCase
) : BaseViewModel<CharacterListState>() {

    override fun setInitialState(): CharacterListState = CharacterListState.Loading

    val characterListLiveData: MutableLiveData<List<Character>> = MutableLiveData()

    init {
        fetchCharacters()
    }

    private fun fetchCharacters() {
        viewModelScope.launch {
            getCharacterListUseCase.invoke(Unit).collect { result ->
                characterListLiveData.postValue(result)
            }
        }
    }
}