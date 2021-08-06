package br.com.cassiano.myappv2.feature.recipeslist.view.flow

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    val navigationEvent = MutableLiveData<Navigation>()
    lateinit var selectedRecipe: String

    fun navigate(navigation: Navigation) {
        navigationEvent.postValue(navigation)
    }

    sealed class Navigation {
        object Recipes : Navigation()
        object Details : Navigation()
    }
}