package com.muratcay.rick_and_morty_multi_module_app.feature.character_list

import com.muratcay.presentation.base.BaseFragment
import com.muratcay.presentation.chacaterlist.CharacterListViewModel
import com.muratcay.rick_and_morty_multi_module_app.R
import com.muratcay.rick_and_morty_multi_module_app.databinding.FragmentCharacterListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterListFragment :
    BaseFragment<FragmentCharacterListBinding, CharacterListViewModel>(R.layout.fragment_character_list) {

    override fun getViewModelClass(): Class<CharacterListViewModel> =
        CharacterListViewModel::class.java

    override fun initObserver() {
    }

    override fun initViews() {

    }

}