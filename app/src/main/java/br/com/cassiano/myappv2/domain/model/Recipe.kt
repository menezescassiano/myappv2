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
                  val time: String)