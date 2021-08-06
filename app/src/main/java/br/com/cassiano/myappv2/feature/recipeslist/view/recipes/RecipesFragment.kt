package br.com.cassiano.myappv2.feature.recipeslist.view.recipes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.cassiano.myappv2.R
import br.com.cassiano.myappv2.databinding.FragmentRecipesBinding
import br.com.cassiano.myappv2.domain.model.Recipe
import br.com.cassiano.myappv2.extension.activityViewModel
import br.com.cassiano.myappv2.feature.recipeslist.view.adapter.RecipesAdapter
import br.com.cassiano.myappv2.feature.recipeslist.view.flow.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class RecipesFragment : Fragment() {

    lateinit var binding: FragmentRecipesBinding

    private val viewModel: RecipesViewModel by viewModel()
    private val flowViewModel: MainViewModel by activityViewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_recipes, container, false)
        setupBinding()
        setupObservables()
        viewModel.getData()
        return binding.root
    }

    private fun setupBinding() {
        binding.apply {
            //todo: is it necessary?
        }
    }

    private fun setupObservables() {
        viewModel.apply {
            onDataResult.observe(viewLifecycleOwner, { setRecyclerView(it) })
            progressBarVisibility.observe(viewLifecycleOwner, { binding.pbProgress.isVisible = it })
        }

    }

    private fun setRecyclerView(list: List<Recipe>) {
        val listAdapter = RecipesAdapter(list)
        binding.rvRecipes.apply {
            adapter = listAdapter
            layoutManager = LinearLayoutManager(context)
            listAdapter.apply {
                selectedRecipe.observe(viewLifecycleOwner, {
                    flowViewModel.selectedRecipe = it
                })
            }
        }
    }

}