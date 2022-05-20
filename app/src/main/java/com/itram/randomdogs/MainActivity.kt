package com.itram.randomdogs

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.itram.randomdogs.databinding.ActivityMainBinding
import com.itram.randomdogs.model.APIService
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnNewDog.setOnClickListener { getRandomDog() }

    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://dog.ceo/api/breeds/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun getRandomDog() {
        CoroutineScope(Dispatchers.IO).launch {
            val call = getRetrofit().create(APIService::class.java).getRandomDog("image/random/")
            val dog = call.body()
            runOnUiThread {
                if (call.isSuccessful) {
                    val images = dog?.image ?: ""
                    // show image
                    Picasso.get().load(images).into(binding.imgDog)
                } else {
                    showError()
                }
            }
        }
    }

    private fun showError() {
        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
    }
}