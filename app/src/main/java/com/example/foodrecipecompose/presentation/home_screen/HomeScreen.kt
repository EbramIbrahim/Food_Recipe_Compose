package com.example.foodrecipecompose.presentation.home_screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.foodrecipecompose.presentation.country_screen.CountriesList
import com.example.foodrecipecompose.presentation.ingredients_component.IngredientsScreen
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

        AnimatedVisibility(visible = state.isLoading) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator(color = Color.Green)
            }
        }

        AnimatedVisibility(visible = !state.isLoading && state.error != null) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(
                    text = "No Internet Connection....",
                    color = Color.Red,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        if (state.allMeals.isNotEmpty()) {

            RandomMealScreen(state = state, navController = navController)

            Spacer(modifier = Modifier.height(6.dp))

            IngredientsScreen(navController = navController)

            Spacer(modifier = Modifier.height(12.dp))

            CountriesList(navController = navController)

            Spacer(modifier = Modifier.height(8.dp))
        }




    }
}








