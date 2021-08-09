package br.com.cassiano.myappv2.feature.recipeslist.view.recipes

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.cassiano.myappv2.domain.model.Recipe
import br.com.cassiano.myappv2.extension.safeRun
import br.com.cassiano.myappv2.usecase.RecipesUseCase
import kotlinx.coroutines.launch

class RecipesViewModel(private val recipeUseCase: RecipesUseCase) : ViewModel() {

    val onDataResult = MutableLiveData<List<Recipe>>()
    val progressBarVisibility = MutableLiveData<Boolean>()
    val onDataError = MutableLiveData<Boolean>()

    fun getData() {
        progressBarVisibility.value = true
        onDataError.value = false
        viewModelScope.launch {
            safeRun(
                onSuccess = {
                    recipeUseCase.execute().also {
                        onDataResult.value = it
                    }
                },
            onError = {
                onDataError.value = true
            })
            progressBarVisibility.value = false
        }
    }
}