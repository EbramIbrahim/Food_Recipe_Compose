package com.example.foodrecipecompose.data.model

import androidx.annotation.DrawableRes

data class Country(
    val countryName: String,
    @DrawableRes val countryFlag: Int,
)