package com.example.shoestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.shoestore.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //For the appbar Navigation

        val navcontroller=this.findNavController(R.id.MyNavHostFragment)
        NavigationUI.setupActionBarWithNavController(this,navcontroller)
    }
    //For the up button to navigate back

    override fun onSupportNavigateUp(): Boolean {
        val navcontroller=this.findNavController(R.id.MyNavHostFragment)
        return navcontroller.navigateUp()
    }
}