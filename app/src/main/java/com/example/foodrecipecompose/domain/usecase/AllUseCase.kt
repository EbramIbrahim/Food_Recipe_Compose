package com.example.foodrecipecompose.domain.usecase

data class AllUseCase(
    val getRandomCategoryMealsUseCase: GetRandomCategoryMealsUseCase,
    val getSearchedMealUseCase: GetSearchedMealUseCase,
    val getCountryMealsUseCase: GetCountryMealsUseCase,
    val getMealDetailsUseCase: GetMealDetailsUseCase,
    val getSavedMealsUseCase: GetSavedMealsUseCase,
)
