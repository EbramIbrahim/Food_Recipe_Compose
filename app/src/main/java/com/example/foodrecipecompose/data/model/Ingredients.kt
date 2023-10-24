package com.example.foodrecipecompose.data.model

import androidx.annotation.DrawableRes

data class Ingredients(
    val name: String,
    @DrawableRes val color: Int,
    @DrawableRes val image: Int
)
