package com.example.foodrecipecompose.presentation


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodrecipecompose.data.local.MealEntity
import com.example.foodrecipecompose.data.repository.MealsRepositoryImpl
import com.example.foodrecipecompose.domain.usecase.AllUseCase
import com.example.foodrecipecompose.presentation.state_event.MealsEvents
import com.example.foodrecipecompose.presentation.state_event.MealsState
import com.example.foodrecipecompose.utils.Constant
import com.example.foodrecipecompose.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MealsViewModel @Inject constructor(
    private val useCase: AllUseCase,
    private val repository: MealsRepositoryImpl
) : ViewModel() {


    private val _allMeals: MutableStateFlow<MealsState> = MutableStateFlow(MealsState())
    val allMeals = _allMeals.asStateFlow()


    init {
        onEvent(MealsEvents.InitScreen)
    }


    fun onEvent(events: MealsEvents) {

        when (events) {
            is MealsEvents.InitScreen -> {
                val category = Constant.categories
                getRandomCategoryMeals(category = category)
                getSavedMeals()

            }

            is MealsEvents.GetSearchedMealsList -> {
                getSearchedMeals(events.query)
            }

            is MealsEvents.GetCountryMealsList -> {
                getCountryMeals(events.country)
            }

            is MealsEvents.GetMealDetails -> {
                getMealDetails(events.id)
            }

            is MealsEvents.DeleteMeal -> {
                deleteMeal(events.mealEntity)
            }

            is MealsEvents.InsertMeal -> {
                insertMeal(events.mealEntity)
            }

            MealsEvents.HideDialog -> {
                _allMeals.update { it.copy(showHideDialog = false) }
            }
            MealsEvents.ShowDialog -> {
                _allMeals.update { it.copy(showHideDialog = true) }
            }
        }

    }


    private fun getRandomCategoryMeals(category: String) =
        useCase.getRandomCategoryMealsUseCase(category).onEach { randomMeal ->
            when (randomMeal) {
                is Resource.Loading -> {
                    _allMeals.update { it.copy(isLoading = true) }
                }

                is Resource.Success -> {
                    randomMeal.data?.meals?.let { meal ->
                        _allMeals.update { it.copy(allMeals = meal, isLoading = false) }
                    }
                }

                is Resource.Error -> {
                    _allMeals.update { it.copy(error = randomMeal.message, isLoading = false) }

                }
            }
        }.launchIn(viewModelScope)


    private fun getSearchedMeals(query: String) = viewModelScope.launch {

        useCase.getSearchedMealUseCase(query).collectLatest { result ->
            when (result) {
                is Resource.Loading -> {
                    _allMeals.update { it.copy(isLoading = true) }
                }

                is Resource.Success -> {
                    result.data?.meals?.let { searchedMealsList ->
                        _allMeals.update {
                            it.copy(
                                searchedMeal = searchedMealsList,
                                isLoading = false
                            )
                        }
                    }
                }

                is Resource.Error -> {
                    _allMeals.update {
                        it.copy(
                            error = result.message,
                            isLoading = false
                        )
                    }
                }
            }
        }
    }


    private fun getCountryMeals(country: String) =
        useCase.getCountryMealsUseCase(country).onEach { result ->

            when (result) {
                is Resource.Loading -> {
                    _allMeals.update { it.copy(isLoading = true) }
                }

                is Resource.Error -> {
                    _allMeals.update { it.copy(error = result.message, isLoading = false) }
                }

                is Resource.Success -> {
                    result.data?.meals?.let { countryMeals ->
                        _allMeals.update { it.copy(countryMeals = countryMeals, isLoading = false) }
                    }
                }
            }
        }.launchIn(viewModelScope)


    private fun getMealDetails(id: String) = viewModelScope.launch {
        useCase.getMealDetailsUseCase(id).collectLatest { result ->
            when (result) {

                is Resource.Error -> {
                    _allMeals.update { it.copy(error = result.message, isLoading = false) }
                }

                is Resource.Loading -> {
                    _allMeals.update { it.copy(isLoading = true, error = null) }
                }

                is Resource.Success -> {
                    result.data?.meals?.let { mealDetails ->
                        _allMeals.update {
                            it.copy(
                                mealDetails = mealDetails,
                                isLoading = false,
                                error = null
                            )
                        }
                    }
                }
            }
        }
    }


    private fun insertMeal(mealEntity: MealEntity) = viewModelScope.launch {
        repository.insertMeal(mealEntity)
    }

    private fun deleteMeal(mealEntity: MealEntity) = viewModelScope.launch {
        repository.deleteMeal(mealEntity)
    }

    private fun getSavedMeals() {
        useCase.getSavedMealsUseCase().onEach { result ->
            when (result) {
                is Resource.Error -> {
                    _allMeals.update { it.copy(error = result.message, isLoading = false) }
                }

                is Resource.Loading -> {
                    _allMeals.update { it.copy(isLoading = true, error = null) }
                }

                is Resource.Success -> {
                    result.data?.let { mealEntities ->
                        _allMeals.update {
                            it.copy(
                                mealsEntity = mealEntities,
                                error = null,
                                isLoading = false
                            )
                        }
                    }
                }
            }
        }.launchIn(viewModelScope)
    }


}










