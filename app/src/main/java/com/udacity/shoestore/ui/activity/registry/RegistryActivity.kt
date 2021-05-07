package com.udacity.shoestore.ui.activity.registry

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.udacity.shoestore.databinding.ActivityRegistryBinding

class RegistryActivity : AppCompatActivity() {

    private val binding by lazy { ActivityRegistryBinding.inflate(layoutInflater) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

    }




}