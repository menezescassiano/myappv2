package br.com.cassiano.myappv2.feature.recipeslist.view.flow

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.cassiano.myappv2.domain.model.Recipe

class MainViewModel : ViewModel() {

    val navigationEvent = MutableLiveData<Navigation>()
    var selectedRecipe: Recipe? = null

    fun navigate(navigation: Navigation) {
        navigationEvent.postValue(navigation)
    }

    sealed class Navigation {
        object Recipes : Navigation()
        object Details : Navigation()
    }
}