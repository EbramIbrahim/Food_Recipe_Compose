package com.example.foodrecipecompose.domain.usecase

import com.example.foodrecipecompose.data.model.RandomCategoryMealsResponse
import com.example.foodrecipecompose.data.repository.MealsRepositoryImpl
import com.example.foodrecipecompose.utils.Resource
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.flow
import java.lang.Exception
import javax.inject.Inject

class GetRandomCategoryMealsUseCase @Inject constructor(
    private val repository: MealsRepositoryImpl
) {


    operator fun invoke(category: String): Flow<Resource<RandomCategoryMealsResponse>> = channelFlow {
        try {
            send(Resource.Loading())
            delay(2000L)
            val result = repository.getRandomCategoryMeals(category)
            send(Resource.Success(result))

        } catch (e: Exception){
            send(Resource.Error(e.message))
        }
    }
}