package org.sabaini.koinexample.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.net.toUri
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.sabaini.koinexample.GlideApp
import org.sabaini.koinexample.ui.viewmodels.HomeViewModel
import org.sabaini.koinexample.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private val homeViewModel: HomeViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root

        homeViewModel.cat.observe(this, { cat ->
            if (cat != null) {
                val imgUri = cat.url.toUri().buildUpon().scheme("https").build()
                GlideApp.with(binding.catImage)
                    .load(imgUri)
                    .into(binding.catImage)
            }
        })

        setContentView(view)
    }
}