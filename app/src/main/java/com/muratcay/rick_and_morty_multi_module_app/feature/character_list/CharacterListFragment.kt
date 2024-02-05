package com.muratcay.rick_and_morty_multi_module_app.feature.character_list

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.muratcay.presentation.base.BaseFragment
import com.muratcay.presentation.chacaterlist.CharacterListState
import com.muratcay.presentation.chacaterlist.CharacterListViewModel
import com.muratcay.rick_and_morty_multi_module_app.R
import com.muratcay.rick_and_morty_multi_module_app.databinding.FragmentCharacterListBinding
import com.muratcay.rick_and_morty_multi_module_app.feature.character_list.adapter.CharacterAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class CharacterListFragment :
    BaseFragment<FragmentCharacterListBinding, CharacterListViewModel>(R.layout.fragment_character_list) {

    override fun getViewModelClass(): Class<CharacterListViewModel> =
        CharacterListViewModel::class.java

    @Inject
    lateinit var characterAdapter: CharacterAdapter

    override fun initObserver() {
        viewModel.fetchCharacters()
        lifecycleScope.launch {
            viewModel.state.flowWithLifecycle(lifecycle, Lifecycle.State.STARTED).collect { state ->
                when (state) {
                    is CharacterListState.Success -> {
                        state.characters.takeIf { it.isNullOrEmpty().not() }
                            ?.let {
                                characterAdapter.submitList(state.characters)
                            }
                        binding.isEmpty = state.characters.isNullOrEmpty()
                        hideProgressBar()
                    }

                    is CharacterListState.Error -> {
                        notify(state.error)
                        hideProgressBar()
                    }

                    is CharacterListState.Loading -> {
                        showProgressBar()
                        delay(1500)
                    }
                }
            }
        }
    }

    override fun initViews() = with(binding) {
        recyclerViewCharacters.adapter = characterAdapter
        characterAdapter.onItemClicked = {
            navigateToDetail(it)
        }
    }

    private fun navigateToDetail(id: Long) {
        val action = CharacterListFragmentDirections.actionCharacterListFragmentToCharacterDetailFragment()
        findNavController().navigate(action)
    }

    private fun hideProgressBar() {
        binding.isLoading = false
    }

    private fun showProgressBar() {
        binding.isLoading = true
    }

}