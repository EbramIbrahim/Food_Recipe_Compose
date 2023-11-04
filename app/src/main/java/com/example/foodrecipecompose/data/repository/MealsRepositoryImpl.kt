package com.example.foodrecipecompose.data.repository

import com.example.foodrecipecompose.data.local.MealDatabase
import com.example.foodrecipecompose.data.local.MealEntity
import com.example.foodrecipecompose.data.model.CountryMealsResponse
import com.example.foodrecipecompose.data.model.MealDetails
import com.example.foodrecipecompose.data.model.MealDetailsResponse
import com.example.foodrecipecompose.data.model.RandomCategoryMealsResponse
import com.example.foodrecipecompose.data.model.SearchMealsResponse
import com.example.foodrecipecompose.data.remote.MealsApi
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MealsRepositoryImpl @Inject constructor(
    private val api: MealsApi,
    private val database: MealDatabase
) {

    suspend fun getRandomCategoryMeals(category: String): RandomCategoryMealsResponse {
        return api.getRandomCategoryMeals(category)
    }

    suspend fun getSearchedMeal(query: String): SearchMealsResponse {
        return api.getSearchedMeal(query)
    }

    suspend fun getCountryMeals(country: String): CountryMealsResponse {
        return api.getCountryMeals(country)
    }

    suspend fun getMealDetails(id: String): MealDetailsResponse {
        return api.getMealDetails(id)
    }

    suspend fun insertMeal(mealEntity: MealEntity) {
        database.mealDao().insertMeal(mealEntity)
    }

    suspend fun deleteMeal(mealEntity: MealEntity) {
        database.mealDao().deleteMeal(mealEntity)
    }

    fun getAllMeals(): Flow<List<MealEntity>> {
        return database.mealDao().getSavedMeals()
    }

    fun getMealsByTime(): Flow<List<MealEntity>> {
        return database.mealDao().getMealsByTime()
    }

    fun getMealsByCountry(): Flow<List<MealEntity>> {
        return database.mealDao().getMealsByCountry()
    }

    fun getMealsByMealName(): Flow<List<MealEntity>> {
        return database.mealDao().getMealsByMealName()
    }



}