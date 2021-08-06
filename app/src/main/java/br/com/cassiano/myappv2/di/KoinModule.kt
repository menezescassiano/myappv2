package br.com.cassiano.myappv2.di

import br.com.cassiano.myappv2.feature.restaurants.view.flow.MainViewModel
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
    //viewModel { RecipeDetailViewModel(resourceManager = get()) }
}

fun loadKoinModules() {
    loadKoinModules(listOf(/*serviceModule, repositoryModule, resourceManager, */viewModelModule))
}