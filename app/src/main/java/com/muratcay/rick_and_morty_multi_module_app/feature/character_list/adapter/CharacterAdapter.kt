package com.muratcay.rick_and_morty_multi_module_app.feature.character_list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.RequestManager
import com.muratcay.domain.models.Character
import com.muratcay.rick_and_morty_multi_module_app.databinding.ListItemCharacterBinding
import javax.inject.Inject

class CharacterAdapter @Inject constructor(
    private val glide: RequestManager
) : ListAdapter<Character, CharacterViewHolder>(CharacterDiffUtilCallback) {

    var onItemClicked: ((Long) -> Unit)? = null

    object CharacterDiffUtilCallback : DiffUtil.ItemCallback<Character>() {

        override fun areItemsTheSame(oldItem: Character, newItem: Character) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Character, newItem: Character) = oldItem == newItem

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder =
        CharacterViewHolder(
            ListItemCharacterBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(getItem(position), glide, onItemClicked?:{})
    }
}