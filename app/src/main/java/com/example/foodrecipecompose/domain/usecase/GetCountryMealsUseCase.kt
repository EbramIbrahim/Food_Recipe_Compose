package com.example.foodrecipecompose.domain.usecase

import com.example.foodrecipecompose.data.model.CountryMealsResponse
import com.example.foodrecipecompose.data.repository.MealsRepositoryImpl
import com.example.foodrecipecompose.utils.Resource
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception
import javax.inject.Inject

class GetCountryMealsUseCase @Inject constructor(
    private val repository: MealsRepositoryImpl
) {


    operator fun invoke(country: String): Flow<Resource<CountryMealsResponse>> = flow {

        try {
            emit(Resource.Loading())
            delay(1000L)

            val result = repository.getCountryMeals(country)
            emit(Resource.Success(result))
        }catch (e: Exception) {
            emit(Resource.Error(e.message))
        }
    }
}





