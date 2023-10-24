package com.example.foodrecipecompose.presentation.search_screen


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.foodrecipecompose.presentation.state_event.MealsEvents
import com.example.foodrecipecompose.presentation.state_event.MealsState

@Composable
fun SearchScreen(
    onEvent: (MealsEvents) -> Unit,
    state: MealsState,
    query: String,
    navController: NavController
) {

    LaunchedEffect(key1 = Unit) {
        onEvent(MealsEvents.GetSearchedMealsList(query = query))
    }

    if (state.isLoading) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    }

    if (state.error != null) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "No Internet Connection....",
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Red
            )
        }
    }


    if (!state.isLoading && state.error == null) {
        Column {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)
            ) {
                items(state.searchedMeal.size) {
                    SearchCardInfo(searchedMeals = state.searchedMeal[it], navController)
                }
            }
        }

    }

}






















