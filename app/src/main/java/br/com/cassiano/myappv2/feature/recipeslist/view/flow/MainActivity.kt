package br.com.cassiano.myappv2.feature.recipeslist.view.flow

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import br.com.cassiano.myappv2.R
import br.com.cassiano.myappv2.extension.defaultNavController
import br.com.cassiano.myappv2.extension.defaultNavigate
import br.com.cassiano.myappv2.extension.observe
import br.com.cassiano.myappv2.feature.recipeslist.view.flow.MainViewModel.Navigation.Details
import br.com.cassiano.myappv2.feature.recipeslist.view.flow.MainViewModel.Navigation.Recipes
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModel()

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupViewModel()
        setContentView(R.layout.activity_navigation)
        setupNavController()
    }

    private fun setupViewModel() {
        viewModel.apply {
            observe(navigationEvent) { it?.let { navigateTo(it) } }
        }
    }

    private fun setupNavController() {
        navController = defaultNavController(R.navigation.navigation_recipes)
    }

    private fun navigateTo(navigation: MainViewModel.Navigation) {
        when (navigation) {
            Recipes -> navController.defaultNavigate(R.id.frag_recipes)
            Details -> navController.defaultNavigate(R.id.frag_details)
        }
    }
}