package br.com.cassiano.myappv2.feature.recipeslist.view.recipes

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import br.com.cassiano.myappv2.domain.model.Recipe
import br.com.cassiano.myappv2.extension.safeRun
import br.com.cassiano.myappv2.feature.recipeslist.view.BaseViewModel
import br.com.cassiano.myappv2.usecase.RecipesUseCase
import kotlinx.coroutines.launch

class RecipesViewModel(private val recipeUseCase: RecipesUseCase) : BaseViewModel() {

    val onDataResult = MutableLiveData<List<Recipe>>()
    val progressBarVisibility = MutableLiveData<Boolean>()

    fun getData() {
        progressBarVisibility.value = true
        viewModelScope.launch {
            safeRun(
                onSuccess = {
                    recipeUseCase.execute().also {
                        onDataResult.value = it
                    }
                })
            progressBarVisibility.value = false
        }
    }
}