package br.com.cassiano.myappv2.di

import br.com.cassiano.myappv2.domain.repository.RecipesRepositoryImpl
import br.com.cassiano.myappv2.feature.recipeslist.view.flow.MainViewModel
import br.com.cassiano.myappv2.feature.recipeslist.view.recipes.RecipesViewModel
import br.com.cassiano.myappv2.network.RetrofitClient
import br.com.cassiano.myappv2.usecase.RecipesUseCase
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

private val serviceModule = module {
    single { RetrofitClient.getApiService() }
}

private val repositoryModule = module {
    single { RecipesRepositoryImpl(api = get()) }
}

private val useCases = module {
    single { RecipesUseCase(repository = get()) }
}

private val viewModelModule = module {
    viewModel { MainViewModel() }
    viewModel { RecipesViewModel(recipeUseCase = get()) }
}

fun loadKoinModules() {
    loadKoinModules(listOf(serviceModule, repositoryModule, useCases, viewModelModule))
}