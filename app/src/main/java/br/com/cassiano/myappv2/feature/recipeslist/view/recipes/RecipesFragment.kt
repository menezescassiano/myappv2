package br.com.cassiano.myappv2.feature.recipeslist.view.recipes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import br.com.cassiano.myappv2.R
import br.com.cassiano.myappv2.databinding.FragmentRecipesBinding
import br.com.cassiano.myappv2.extension.activityViewModel
import br.com.cassiano.myappv2.feature.recipeslist.view.flow.MainViewModel
import br.com.cassiano.myappv2.feature.recipeslist.view.flow.MainViewModel.Navigation.Details
import org.koin.androidx.viewmodel.ext.android.viewModel

class RecipesFragment : Fragment() {

    lateinit var binding: FragmentRecipesBinding

    private val viewModel: RecipesViewModel by viewModel()
    private val flowViewModel: MainViewModel by activityViewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_recipes, container, false)
        /*setupViewModel()
        setupListener()*/
        setupBinding()
        return binding.root
    }

    private fun setupBinding() {
        binding.apply {
            tvText.setOnClickListener {
                flowViewModel.navigate(Details)
            }
        }
    }

}