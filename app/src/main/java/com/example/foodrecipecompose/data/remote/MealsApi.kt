package com.example.foodrecipecompose.data.remote

import com.example.foodrecipecompose.data.model.CountryMealsResponse
import com.example.foodrecipecompose.data.model.MealDetails
import com.example.foodrecipecompose.data.model.MealDetailsResponse
import com.example.foodrecipecompose.data.model.RandomCategoryMealsResponse
import com.example.foodrecipecompose.data.model.SearchMealsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MealsApi {


    @GET("filter.php")
    suspend fun getRandomCategoryMeals(
        @Query("c") category: String
    ): RandomCategoryMealsResponse

    @GET("search.php")
    suspend fun getSearchedMeal(
        @Query("s") query: String
    ): SearchMealsResponse

    @GET("filter.php")
    suspend fun getCountryMeals(
        @Query("a") country: String
    ): CountryMealsResponse

    @GET("lookup.php")
    suspend fun getMealDetails(
        @Query("i") id: String
    ): MealDetailsResponse


}





