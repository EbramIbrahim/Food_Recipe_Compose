package com.example.foodrecipecompose.domain.usecase


import com.example.foodrecipecompose.data.model.MealDetails
import com.example.foodrecipecompose.data.model.MealDetailsResponse
import com.example.foodrecipecompose.data.repository.MealsRepositoryImpl
import com.example.foodrecipecompose.utils.Resource
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception
import javax.inject.Inject

class GetMealDetailsUseCase @Inject constructor(
    private val repository: MealsRepositoryImpl
) {

    operator fun invoke(id: String): Flow<Resource<MealDetailsResponse>> = flow {

        try {
            emit(Resource.Loading())

            val result = repository.getMealDetails(id)
            emit(Resource.Success(result))

        } catch (e: Exception) {
            emit(Resource.Error(e.message))
        }
    }



}














