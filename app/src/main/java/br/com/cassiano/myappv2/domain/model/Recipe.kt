package br.com.cassiano.myappv2.domain.model

data class Recipe(val calories: String,
                  val carbos: String,
                  val description: String,
                  val difficulty: Int,
                  val fats: String,
                  val headline: String,
                  val id: String,
                  val image: String,
                  val name: String,
                  val proteins: String,
                  val thumb: String,
                  val time: String) {

    companion object {
        fun mock() = Recipe(
            calories = "calories",
            carbos = "carbos",
            description = "description",
            difficulty = 1,
            fats = "fats",
            headline = "headline",
            id = "id",
            image = "image",
            name = "name",
            proteins = "proteins",
            thumb = "thumb",
            time = "time"
        )
    }
}