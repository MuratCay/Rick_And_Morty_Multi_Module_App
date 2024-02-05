package com.muratcay.rick_and_morty_multi_module_app.feature.character_detail

import com.muratcay.presentation.base.BaseFragment
import com.muratcay.presentation.character_detail.CharacterDetailViewModel
import com.muratcay.rick_and_morty_multi_module_app.R
import com.muratcay.rick_and_morty_multi_module_app.databinding.FragmentCharacterDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterDetailFragment : BaseFragment<FragmentCharacterDetailBinding, CharacterDetailViewModel>(R.layout.fragment_character_detail) {

    override fun getViewModelClass(): Class<CharacterDetailViewModel> =
        CharacterDetailViewModel::class.java

    override fun initObserver() {

    }

    override fun initViews() {

    }

}