package br.com.cassiano.myappv2.data.api

import br.com.cassiano.myappv2.data.response.RecipeResponse
import retrofit2.http.GET

interface ServiceApi {

    @GET("recipes.json")
    suspend fun getRecipes(): List<RecipeResponse>

}