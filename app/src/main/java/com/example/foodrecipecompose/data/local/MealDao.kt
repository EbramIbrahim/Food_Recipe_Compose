package com.example.foodrecipecompose.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface MealDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMeal(mealEntity: MealEntity)

    @Delete
    suspend fun deleteMeal(mealEntity: MealEntity)

    @Query("SELECT * FROM meal_table")
    fun getSavedMeals(): Flow<List<MealEntity>>

    @Query("SELECT * FROM meal_table ORDER BY times ASC")
    fun getMealsByTime(): Flow<List<MealEntity>>

    @Query("SELECT * FROM meal_table ORDER BY mealCountry ASC")
    fun getMealsByCountry(): Flow<List<MealEntity>>

    @Query("SELECT * FROM meal_table ORDER BY mealName ASC")
    fun getMealsByMealName(): Flow<List<MealEntity>>


}








