package com.example.examplemvvm.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.example.examplemvvm.databinding.ActivityMainBinding
import com.example.examplemvvm.ui.viewmodel.FraseViewModel
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val fraseViewModel: FraseViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fraseViewModel.create()

        fraseViewModel.fraseModel.observe(this, Observer { frase ->
            binding.tvMessage.text = frase!!.message
            binding.tvAuthor.text = frase.author
        })

        fraseViewModel.isLoading.observe(this) {
            binding.progressCircular.isVisible = it
        }

        binding.viewContainer.setOnClickListener {
            fraseViewModel.getFraseRandom()
        }
    }
}