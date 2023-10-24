package com.example.foodrecipecompose.utils

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception

fun <T>usecase(dataSource: T): Flow<Resource<T>> = flow {

    try {
        emit(Resource.Loading())
        emit(Resource.Success(dataSource))

    } catch (e: Exception){
        emit(Resource.Error(e.message))
    }

}








