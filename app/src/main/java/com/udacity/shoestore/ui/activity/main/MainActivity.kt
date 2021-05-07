package com.udacity.shoestore.ui.activity.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ActivityMainBinding
import timber.log.Timber

class MainActivity : AppCompatActivity() {


    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private lateinit var navController:NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        navController=Navigation.findNavController(this,R.id.fragment_container_view)
        setSupportActionBar(binding.toolbar)


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
              //  val action = R.id.action_to_fragment_onboarding
             //   newGame(action)
                true
            }
            R.id.nav_logout -> {
               // val action = R.id.action_to_fragment_details
               // newGame(action)
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }


    private fun newGame(action: Int) {
        navController.navigate(action)
    }
}
