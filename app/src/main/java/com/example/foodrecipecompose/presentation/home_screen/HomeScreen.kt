package com.example.foodrecipecompose.presentation.home_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.foodrecipecompose.presentation.country_screen.CountriesList
import com.example.foodrecipecompose.presentation.main_component.IngredientsScreen
import com.example.foodrecipecompose.presentation.main_component.RandomMealScreen
import com.example.foodrecipecompose.presentation.state_event.MealsState

@Composable
fun HomeScreen(
    state: MealsState,
    navController: NavController,
    modifier: Modifier
) {

    val scrollableState = rememberScrollState()
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(scrollableState),

        ) {

        RandomMealScreen(state = state, navController = navController)

        Spacer(modifier = Modifier.height(6.dp))

        IngredientsScreen(navController = navController)

        Spacer(modifier = Modifier.height(12.dp))

        CountriesList(navController = navController)

        Spacer(modifier = Modifier.height(8.dp))



    }
}








