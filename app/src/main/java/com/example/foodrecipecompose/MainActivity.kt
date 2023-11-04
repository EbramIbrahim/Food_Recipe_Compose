package com.example.foodrecipecompose

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.rememberNavController
import com.example.foodrecipecompose.data.model.BottomNavItem
import com.example.foodrecipecompose.presentation.MealsViewModel
import com.example.foodrecipecompose.presentation.navigation.BottomNavItemScreen
import com.example.foodrecipecompose.presentation.navigation.SetUpNavHost
import com.example.foodrecipecompose.ui.theme.FoodRecipeComposeTheme
import com.example.foodrecipecompose.utils.Screen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodRecipeComposeTheme {
                val viewModel: MealsViewModel = hiltViewModel()
                val mealState by viewModel.state.collectAsState()
                val navController = rememberNavController()
                val context = LocalContext.current



                Scaffold(bottomBar = {

                    BottomNavItemScreen(
                        navController = navController,
                        items = listOf(
                            BottomNavItem(
                                name = "Home",
                                route = Screen.HomeScreen.route,
                                icon = R.drawable.ic_home
                            ),

                            BottomNavItem(
                                name = "BookMark",
                                route = Screen.SavedMealsScreen.route,
                                icon = R.drawable.outlined_bookmark
                            ),
                        ),
                        onItemClick = {
                            navController.navigate(it.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                            }
                        }

                    )
                }
                ) {

                    SetUpNavHost(
                        onEvent = viewModel::onEvent,
                        state = mealState,
                        navHostController = navController,
                        context = context,
                        modifier = Modifier.padding(it)
                    )
                }
            }
        }
    }
}
