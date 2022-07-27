package com.udacity.shoestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import com.udacity.shoestore.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //Create binding variable for Data Binding
    private lateinit var binding: ActivityMainBinding

    //Create app bar configuration
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Bind view to layout
        binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        //Find navigation controller from myNavHostFragment
        val navController = findNavController(R.id.myNavHostFragment)

        appBarConfiguration = AppBarConfiguration(navController.graph)
        }
    override fun onNavigateUp(): Boolean {
        val navController = this.findNavController((R.id.navigation))
        return navController.navigateUp()
    }
}

