package com.example.foodrecipecompose.data.mapper

import com.example.foodrecipecompose.data.model.MealDetails
import com.example.foodrecipecompose.data.model.MealIngredients


fun MealDetails.toMealIngredients(): MealIngredients {

    return MealIngredients(
        strIngredient1 = strIngredient1.toString(),
        strIngredient2 = strIngredient2.toString(),
        strIngredient3 = strIngredient3.toString(),
        strIngredient4 = strIngredient4.toString(),
        strIngredient5 = strIngredient5.toString(),
        strIngredient6 = strIngredient6.toString(),
        strIngredient7 = strIngredient7.toString(),
        strIngredient8 = strIngredient8.toString(),
        strIngredient9 = strIngredient9.toString(),
        strIngredient10 = strIngredient10.toString(),
        strIngredient11 = strIngredient11.toString(),
        strIngredient12 = strIngredient12.toString(),
        strIngredient13 = strIngredient13.toString(),
        strIngredient14 = strIngredient14.toString(),
        strIngredient15 = strIngredient15.toString(),
        strIngredient16 = strIngredient16.toString(),
        strIngredient17 = strIngredient17.toString(),
        strIngredient18 = strIngredient18.toString(),
        strIngredient19 = strIngredient19.toString(),
        strIngredient20 = strIngredient20.toString(),

    )
}