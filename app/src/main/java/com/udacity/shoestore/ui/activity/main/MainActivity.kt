package com.udacity.shoestore.ui.activity.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ActivityMainBinding
import com.udacity.shoestore.ui.activity.registry.RegistryActivity
import timber.log.Timber

class MainActivity : AppCompatActivity() {


    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        val navController = Navigation.findNavController(this, R.id.fragment_container_view)
        NavigationUI.setupWithNavController(binding.toolbar, navController)


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.shop_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        return when (item.itemId) {
            R.id.nav_details -> {
                newGame(false)
                true
            }
            R.id.nav_logout -> {
                newGame(true)
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }


    private fun newGame(isIntent: Boolean) {
        if (!isIntent) {
            val navController = Navigation.findNavController(this, R.id.fragment_container_view)
            val action = R.id.action_to_fragment_shoe_details
            navController.navigate(action)
        } else {
            val action = Intent(this, RegistryActivity::class.java)
            startActivity(action )
            finish()
        }
    }
}
