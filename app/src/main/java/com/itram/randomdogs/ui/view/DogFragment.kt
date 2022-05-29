package com.itram.randomdogs.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide
import com.itram.randomdogs.databinding.FragmentDogBinding
import com.itram.randomdogs.ui.viewmodel.DogViewModel

class DogFragment : Fragment() {

    private lateinit var binding: FragmentDogBinding
    private val dogViewModel: DogViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentDogBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = dogViewModel
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dogViewModel.onCreate()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dogViewModel.randomImage.observe(viewLifecycleOwner) {
            Glide
                .with(this)
                .load(it)
                .centerCrop()
                .into(binding.imgDog)
        }
    }
}