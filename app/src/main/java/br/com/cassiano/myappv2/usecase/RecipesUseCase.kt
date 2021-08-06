package br.com.cassiano.myappv2.usecase

import br.com.cassiano.myappv2.domain.repository.RecipesRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RecipesUseCase(val repository: RecipesRepositoryImpl) {

    suspend fun execute() = withContext(Dispatchers.IO){ repository.getRecipes() }
}