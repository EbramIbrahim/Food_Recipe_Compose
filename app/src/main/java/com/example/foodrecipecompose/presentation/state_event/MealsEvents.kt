package com.example.foodrecipecompose.presentation.state_event

import com.example.foodrecipecompose.data.local.MealEntity

sealed interface MealsEvents {

    object InitScreen: MealsEvents
    class GetSearchedMealsList(val query: String): MealsEvents
    class GetCountryMealsList(val country: String): MealsEvents
    class GetMealDetails(val id: String): MealsEvents
    class InsertMeal(val mealEntity: MealEntity): MealsEvents
    class DeleteMeal(val mealEntity: MealEntity): MealsEvents
    object ShowDialog: MealsEvents
    object HideDialog: MealsEvents

    class MealSortType(val sortType: SortType): MealsEvents

}









