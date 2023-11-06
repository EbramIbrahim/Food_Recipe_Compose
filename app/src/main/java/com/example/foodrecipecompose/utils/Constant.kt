package com.example.foodrecipecompose.utils

import com.example.foodrecipecompose.R
import com.example.foodrecipecompose.data.model.Country
import com.example.foodrecipecompose.data.model.Ingredients


object Constant {


    const val BASE_URL = "https://www.themealdb.com/api/json/v1/1/"

    val categories = arrayOf(
        "Beef",
        "Chicken",
        "Dessert",
        "Lamb",
        "Miscellaneous",
        "Pasta",
        "Pork",
        "Seafood",
        "Starter",
        "Side",
        "Vegan",
        "Vegetarian",
        "Breakfast",
        "Goat",
    ).random()

    val ingredients = arrayOf(
        Ingredients("Tomato", R.color.tomato_color, R.drawable.tomato),
        Ingredients("Corn", R.color.corn_color, R.drawable.corn),
        Ingredients("Chicken", R.color.chicken_color, R.drawable.chicken),
        Ingredients("Egg", R.color.egg_color, R.drawable.egg),
        Ingredients("Garlic", R.color.garlic_color, R.drawable.garlic),
        Ingredients("Carrot", R.color.carrot_color, R.drawable.carrot),
        Ingredients("Banana", R.color.banana_color, R.drawable.banana),
        Ingredients("Eggplant", R.color.eggplant_color, R.drawable.eggplant),
        Ingredients("Coconut", R.color.coconut_color, R.drawable.coconut),
        Ingredients("Lemon", R.color.lemon_color, R.drawable.lemon),
        Ingredients("Butter", R.color.butter_color, R.drawable.butter),
        Ingredients("Avocado", R.color.avocado_color, R.drawable.avocado),
    )


    val countries = arrayOf(
        Country("Canadian",R.drawable.canada),
        Country("Vietnamese",R.drawable.vietnam),
        Country("American",R.drawable.united_states),
        Country("Chinese",R.drawable.chinese),
        Country("Egyptian",R.drawable.egypt),
        Country("French",R.drawable.france),
        Country("Italian",R.drawable.italy),
        Country("Mexican",R.drawable.mexico),
        Country("Spanish",R.drawable.spain),
    )


}
