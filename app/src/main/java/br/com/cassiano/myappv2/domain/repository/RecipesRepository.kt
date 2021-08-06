package br.com.cassiano.myappv2.domain.repository

import br.com.cassiano.myappv2.domain.model.Recipe

interface RecipesRepository {

    suspend fun getRecipes() : List<Recipe>
}