package com.itram.randomdogs.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.itram.randomdogs.databinding.FragmentFavBinding
import com.itram.randomdogs.ui.viewmodel.DogViewModel
import com.squareup.picasso.Picasso

class FavFragment : Fragment() {

    private lateinit var binding: FragmentFavBinding
    private val dogViewModel: DogViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentFavBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dogViewModel.onCreate()

        binding.btnNewDog.setOnClickListener(showNewDog)

        dogViewModel.randomImage.observe(viewLifecycleOwner) {
            Picasso
                .get()
                .load(it)
                .fit()
                .centerCrop()
                .noFade()
                .into(binding.imgDog)
        }

        dogViewModel.isLoading.observe(viewLifecycleOwner) {
            binding.progress.isVisible = it
        }
    }

    private val showNewDog = View.OnClickListener {
        dogViewModel.randomDog()
    }
}