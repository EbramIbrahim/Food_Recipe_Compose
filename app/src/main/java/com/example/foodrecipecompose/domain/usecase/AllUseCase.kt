package com.example.foodrecipecompose.domain.usecase

import com.example.foodrecipecompose.domain.usecase.database_usecase.GetSavedMealsUseCase

data class AllUseCase(
    val getRandomCategoryMealsUseCase: GetRandomCategoryMealsUseCase,
    val getSearchedMealUseCase: GetSearchedMealUseCase,
    val getCountryMealsUseCase: GetCountryMealsUseCase,
    val getMealDetailsUseCase: GetMealDetailsUseCase,
    val getSavedMealsUseCase: GetSavedMealsUseCase,
)
