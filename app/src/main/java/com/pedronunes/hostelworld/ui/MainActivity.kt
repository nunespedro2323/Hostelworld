package com.pedronunes.hostelworld.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.pedronunes.hostelworld.databinding.ActivityMainBinding
import com.pedronunes.hostelworld.di.AppComponent
import com.pedronunes.hostelworld.di.AppModule
import com.pedronunes.hostelworld.di.DaggerAppComponent
import com.pedronunes.hostelworld.viewmodel.PropertiesViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private lateinit var binding: ActivityMainBinding
    private lateinit var appComponent: AppComponent
    lateinit var propertiesViewModel: PropertiesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        appComponent = DaggerAppComponent.builder().appModule(AppModule()).build()

        val navHostFragment =
            supportFragmentManager.findFragmentById(binding.navHostFragment.id) as NavHostFragment
        navController = navHostFragment.navController

        propertiesViewModel = ViewModelProvider(
            this, appComponent.getPropertiesViewModelFactory()
        )[PropertiesViewModel::class.java]
        propertiesViewModel.fetchProperties()
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    override fun onBackPressed() {
        if (!navController.popBackStack()) {
            super.onBackPressed()
        }
    }
}