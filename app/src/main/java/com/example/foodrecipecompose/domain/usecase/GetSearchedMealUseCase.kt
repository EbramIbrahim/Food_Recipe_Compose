package com.example.foodrecipecompose.domain.usecase

import com.example.foodrecipecompose.data.model.SearchMealsResponse
import com.example.foodrecipecompose.data.repository.MealsRepositoryImpl
import com.example.foodrecipecompose.utils.Resource
import com.example.foodrecipecompose.utils.usecase
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception
import javax.inject.Inject

class GetSearchedMealUseCase @Inject constructor(
    private val repository: MealsRepositoryImpl
) {

    operator fun invoke(query: String): Flow<Resource<SearchMealsResponse>> = flow {

        try {
            emit(Resource.Loading())
            delay(2000L)
            val result = repository.getSearchedMeal(query)
            emit(Resource.Success(result))

        } catch (e: Exception){
            emit(Resource.Error(e.message))
        }
    }

}






