package com.itram.randomdogs.ui.view

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.itram.randomdogs.databinding.ActivityMainBinding
import com.itram.randomdogs.ui.viewmodel.DogViewModel
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val dogViewModel: DogViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dogViewModel.onCreate()

        binding.btnNewDog.setOnClickListener(showNewDog)


        dogViewModel.randomImage.observe(this, Observer {
            Picasso
                .get()
                .load(it)
                .fit()
                .centerCrop()
                .noFade()
                .into(binding.imgDog)
        })

        dogViewModel.isLoading.observe(this, Observer {
            binding.progress.isVisible = it
        })
    }

    private val showNewDog = View.OnClickListener {
        dogViewModel.randomDog()
    }
}