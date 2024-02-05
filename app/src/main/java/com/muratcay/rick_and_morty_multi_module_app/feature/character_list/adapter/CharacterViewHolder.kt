package com.muratcay.rick_and_morty_multi_module_app.feature.character_list.adapter

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.muratcay.domain.models.Character
import com.muratcay.rick_and_morty_multi_module_app.databinding.ListItemCharacterBinding

class CharacterViewHolder(private val binding: ListItemCharacterBinding) : RecyclerView.ViewHolder(binding.root) {
    @SuppressLint("SetTextI18n")
    fun bind(item: Character, glide: RequestManager, onItemClicked: (Long) -> Unit) = with(binding) {
            textViewCharacterName.text = item.name
            glide.load(item.image).into(imageViewCharacter)
            root.setOnClickListener {
                onItemClicked(item.id.toLong())
            }
            textViewStatus.text = "${item.status} - ${item.species}"
            textViewKnownLocation.text = item.characterLocation.name
        }
}