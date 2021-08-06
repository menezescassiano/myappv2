package br.com.cassiano.myappv2.data.mapper

import br.com.cassiano.myappv2.data.response.RecipeResponse
import br.com.cassiano.myappv2.domain.model.Recipe

object RecipesMapper {

    fun RecipeResponse.toRecipe() = Recipe(
        calories = calories,
        carbos = carbos,
        description = description,
        difficulty = difficulty,
        fats = fats,
        headline = headline,
        id = id,
        image = image,
        name = name,
        proteins = proteins,
        thumb = thumb,
        time = time
    )
}