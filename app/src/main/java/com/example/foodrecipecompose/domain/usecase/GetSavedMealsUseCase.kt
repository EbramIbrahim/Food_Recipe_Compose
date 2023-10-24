package com.example.foodrecipecompose.domain.usecase

import com.example.foodrecipecompose.data.local.MealEntity
import com.example.foodrecipecompose.data.repository.MealsRepositoryImpl
import com.example.foodrecipecompose.utils.Resource
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow
import java.lang.Exception
import javax.inject.Inject

class GetSavedMealsUseCase @Inject constructor(
    private val repository: MealsRepositoryImpl
) {


    operator fun invoke(): Flow<Resource<List<MealEntity>>> = channelFlow {
        try {
            send(Resource.Loading())
            delay(1000)

             repository.getAllMeals().collectLatest {
                send(Resource.Success(it))
            }

        } catch (e: Exception) {
            send(Resource.Error(e.message))
        }
    }

}














