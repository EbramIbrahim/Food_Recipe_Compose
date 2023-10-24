package com.example.foodrecipecompose.presentation.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.foodrecipecompose.presentation.saved_meal_screen.SavedMealsScreen
import com.example.foodrecipecompose.presentation.details_screen.DetailsScreen
import com.example.foodrecipecompose.presentation.country_screen.CountryMealsScreen
import com.example.foodrecipecompose.presentation.home_screen.HomeScreen
import com.example.foodrecipecompose.presentation.search_screen.SearchScreen
import com.example.foodrecipecompose.presentation.state_event.MealsEvents
import com.example.foodrecipecompose.presentation.state_event.MealsState
import com.example.foodrecipecompose.utils.Screen

@Composable
fun SetUpNavHost(
    onEvent: (MealsEvents) -> Unit,
    state: MealsState,
    navHostController: NavHostController,
    context: Context,
    modifier: Modifier

) {

    NavHost(
        navController = navHostController,
        startDestination = Screen.HomeScreen.route,
        route = "Root_Route"
    ) {

        composable(route = Screen.HomeScreen.route) {
            HomeScreen(state = state, navController = navHostController, modifier = modifier)
        }

        composable(
            route = Screen.SearchScreen.route + "/{query}",
            arguments = listOf(
                navArgument(name = "query") {
                    type = NavType.StringType
                }
            )
        ) { entry ->
            SearchScreen(
                onEvent = onEvent,
                state = state,
                query = entry.arguments?.getString("query")!!,
                navController = navHostController
            )
        }

        composable(
            route = Screen.CountryScreen.route + "/{country}",
            arguments = listOf(
                navArgument(name = "country") {
                    type = NavType.StringType
                }
            )
        ) { entry ->
            CountryMealsScreen(
                onEvent = onEvent,
                state = state,
                country = entry.arguments?.getString("country")!!,
                navController = navHostController
            )
        }

        composable(
            route = Screen.MealDetailsScreen.route + "/{mealId}",
            arguments = listOf(
                navArgument(name = "mealId") {
                    type = NavType.StringType
                }
            )
        ) { entry ->
            DetailsScreen(
                mealsDetailsState = state,
                context = context,
                onEvent = onEvent,
                mealId = entry.arguments?.getString("mealId")!!
            )
        }

        composable(route = Screen.SavedMealsScreen.route) {
            SavedMealsScreen(onEvent = onEvent, state = state, navController = navHostController)
        }


    }

}




