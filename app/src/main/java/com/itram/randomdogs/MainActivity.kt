package com.itram.randomdogs

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.itram.randomdogs.databinding.ActivityMainBinding
import com.itram.randomdogs.viewmodel.DogViewModel
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val dogViewModel: DogViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

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
    }

    private val showNewDog = View.OnClickListener {
        dogViewModel.getRandomDog()
    }


}