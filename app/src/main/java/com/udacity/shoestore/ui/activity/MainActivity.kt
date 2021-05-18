package com.udacity.shoestore.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       val binding= DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main)

        setSupportActionBar(binding.toolbar)

        val navHostFragment:NavHostFragment = supportFragmentManager.findFragmentById(R.id.fragment_container_view) as NavHostFragment
        val navController=navHostFragment.navController
        NavigationUI.setupWithNavController(binding.toolbar, navController)


    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController( R.id.fragment_container_view)
        return NavigationUI.navigateUp(navController,null)
    }


}
