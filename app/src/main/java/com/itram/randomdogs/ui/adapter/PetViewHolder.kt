package com.itram.randomdogs.ui.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.itram.randomdogs.data.database.entities.DogEntity
import com.itram.randomdogs.databinding.ItemPetBinding

class PetViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    var binding = ItemPetBinding.bind(view)

    fun render(dogEntity: DogEntity) {

        Glide
            .with(binding.ivDog.context)
            .load(dogEntity.image)
            .centerCrop()
            .into(binding.ivDog)
    }
}