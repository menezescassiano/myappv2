package br.com.cassiano.myappv2.di

import br.com.cassiano.myappv2.feature.recipeslist.view.details.DetailsViewModel
import br.com.cassiano.myappv2.feature.recipeslist.view.flow.MainViewModel
import br.com.cassiano.myappv2.feature.recipeslist.view.recipes.RecipesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

private val serviceModule = module {
    //single { RetrofitClient.getApiService() }
}

private val repositoryModule = module {
    //single { DataRepository(service = get()) }
}

private val resourceManager = module {
    //single { ResourceManager(context = get()) }
}

private val viewModelModule = module {
    viewModel { MainViewModel(/*repository = get()*/) }
    viewModel { RecipesViewModel(/*repository = get()*/) }
    viewModel { DetailsViewModel(/*repository = get()*/) }
    //viewModel { RecipeDetailViewModel(resourceManager = get()) }
}

fun loadKoinModules() {
    loadKoinModules(listOf(/*serviceModule, repositoryModule, resourceManager, */viewModelModule))
}