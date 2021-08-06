package br.com.cassiano.myappv2.feature.recipeslist.view.recipes

import androidx.lifecycle.viewModelScope
import br.com.cassiano.myappv2.extension.safeRun
import br.com.cassiano.myappv2.feature.recipeslist.view.BaseViewModel
import br.com.cassiano.myappv2.usecase.RecipesUseCase
import kotlinx.coroutines.launch

class RecipesViewModel(private val recipeUseCase: RecipesUseCase) : BaseViewModel() {

    fun getdata() {
        viewModelScope.launch {
            safeRun(
                onSuccess = {
                    recipeUseCase.execute().also {
                        println("aeaeae$it")
                    }
                })
        }
    }
}