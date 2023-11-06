package com.example.foodrecipecompose.utils

sealed class Screen(val route: String) {
    object HomeScreen: Screen("home_screen")
    object SearchScreen: Screen("search_screen")
    object CountryScreen: Screen("country_screen")
    object MealDetailsScreen: Screen("meal_details_screen")
    object SavedMealsScreen: Screen("saved_meals_screen")

}
