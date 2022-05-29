package com.itram.randomdogs.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import com.itram.randomdogs.databinding.FragmentFavBinding
import com.itram.randomdogs.ui.adapter.PetAdapter
import com.itram.randomdogs.ui.viewmodel.FavViewModel

class FavFragment : Fragment() {

    private lateinit var binding: FragmentFavBinding
    private val musicViewModel: FavViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentFavBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        musicViewModel.onCreate()
        initRecyclerView()
    }

    private fun initRecyclerView() {
        val manager = GridLayoutManager(context, 3)
        val decoration = DividerItemDecoration(context, manager.orientation)
        binding.rvPets.layoutManager = manager
        musicViewModel.totalFavDogs.observe(viewLifecycleOwner) {
            binding.rvPets.adapter = PetAdapter(it)
        }

        binding.rvPets.addItemDecoration(decoration)
    }
}