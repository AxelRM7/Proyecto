package com.example.proyecto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var  navCon: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bottomNavV: BottomNavigationView =findViewById(R.id.NavBottom)
        val navHostFra =supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navCon = navHostFra.navController
        bottomNavV.setupWithNavController(navCon)
    }
}