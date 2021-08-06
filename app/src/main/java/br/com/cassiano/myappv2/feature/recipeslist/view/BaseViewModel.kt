package br.com.cassiano.myappv2.feature.recipeslist.view

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel() {

    val genericError = MutableLiveData<Exception>()

}