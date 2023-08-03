package com.pedronunes.propertiesapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.google.android.gms.maps.MapsInitializer
import com.pedronunes.propertiesapp.databinding.ActivityMainBinding
import com.pedronunes.propertiesapp.di.AppComponent
import com.pedronunes.propertiesapp.di.AppModule
import com.pedronunes.propertiesapp.di.DaggerAppComponent
import com.pedronunes.propertiesapp.viewmodel.PropertiesViewModel

class MainActivity : AppCompatActivity() {
    lateinit var navController: NavController
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

        MapsInitializer.initialize(this, MapsInitializer.Renderer.LATEST) {}
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