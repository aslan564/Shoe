package com.udacity.shoestore.ui.activity.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.google.android.material.navigation.NavigationView
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ActivityMainBinding
import timber.log.Timber

class MainActivity : AppCompatActivity() {


    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private lateinit var navController:NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        Timber.plant(Timber.DebugTree())
        navController=Navigation.findNavController(this,R.id.fragment_container_view)
       // NavigationUI.setupWithNavController(this@MainActivity,navController)
        /*val navDestination=
            NavigationView.OnNavigationItemSelectedListener { item ->
                when (item.itemId) {
                    R.layout.fragment_onboarding->{

                    }
                    R.layout.fragment_shoes->{

                    }
                }
                false
            }*/
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.shop_menu, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        return when (item.itemId) {
            R.id.nav_instruction -> {
                newGame(item.title.toString())
                true
            }
            R.id.nav_details -> {
                newGame(item.title.toString())
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun newGame(message:String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        val action = R.id.action_to_fragment_onboarding
        navController.navigate(action)
    }
}
