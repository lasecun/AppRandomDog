package com.itram.randomdogs.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.itram.randomdogs.R
import com.itram.randomdogs.data.database.entities.DogEntity

class PetAdapter(private val petList: List<DogEntity>) : RecyclerView.Adapter<PetViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PetViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return PetViewHolder(layoutInflater.inflate(R.layout.item_pet, parent, false))
    }

    override fun onBindViewHolder(holder: PetViewHolder, position: Int) {
        val dog = petList[position]
        holder.render(dog)
    }

    override fun getItemCount(): Int = petList.size
}