package com.example.foodrecipecompose.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "meal_table")
data class MealEntity(
    @PrimaryKey(autoGenerate = false)
    val mealId: String,
    val mealName: String,
    val mealImage: String,
    val mealCountry: String,
    val times: Long
)
