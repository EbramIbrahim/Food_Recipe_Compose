package com.example.foodrecipecompose.presentation.state_event

import com.example.foodrecipecompose.data.local.MealEntity
import com.example.foodrecipecompose.data.model.CountryMeals
import com.example.foodrecipecompose.data.model.Meal
import com.example.foodrecipecompose.data.model.MealDetails
import com.example.foodrecipecompose.data.model.SearchedMeals

data class MealsState(
    val allMeals: List<Meal> = emptyList(),
    val searchedMeal: List<SearchedMeals> = emptyList(),
    val countryMeals: List<CountryMeals> = emptyList(),
    val mealDetails: List<MealDetails> = emptyList(),
    val mealsEntity: List<MealEntity> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null,
    val showHideDialog: Boolean = false
)
