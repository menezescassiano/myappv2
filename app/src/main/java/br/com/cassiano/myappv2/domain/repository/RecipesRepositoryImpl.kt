package br.com.cassiano.myappv2.domain.repository

import br.com.cassiano.myappv2.data.api.ServiceApi
import br.com.cassiano.myappv2.data.mapper.RecipesMapper.toRecipe
import br.com.cassiano.myappv2.domain.model.Recipe

class RecipesRepositoryImpl(private val api: ServiceApi) : RecipesRepository {

    override suspend fun getRecipes(): List<Recipe> = api.getRecipes().map { it.toRecipe() }

}