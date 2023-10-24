package com.example.foodrecipecompose.presentation.saved_meal_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.foodrecipecompose.R
import com.example.foodrecipecompose.data.local.MealEntity
import com.example.foodrecipecompose.presentation.main_component.AlertMessage
import com.example.foodrecipecompose.presentation.main_component.EmptyListScreen
import com.example.foodrecipecompose.presentation.state_event.MealsEvents
import com.example.foodrecipecompose.presentation.state_event.MealsState
import com.example.foodrecipecompose.utils.Screen


@Composable
fun SavedMealsScreen(
    onEvent: (MealsEvents) -> Unit,
    state: MealsState,
    navController: NavController
) {

    Column(modifier = Modifier.fillMaxSize()) {

        if (state.mealsEntity.isEmpty()) {
            EmptyListScreen()
        } else {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                content = {
                    items(state.mealsEntity.size) {
                        SavedMealCard(
                            mealEntity = state.mealsEntity[it],
                            navController = navController,
                            onEvent = onEvent,
                            state = state
                        )
                    }
                }
            )
        }

    }

}


@Composable
fun SavedMealCard(
    mealEntity: MealEntity,
    navController: NavController,
    onEvent: (MealsEvents) -> Unit,
    state: MealsState
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(260.dp)
            .clip(RoundedCornerShape(16.dp))
            .padding(12.dp)
            .clickable {
                navController.navigate(Screen.MealDetailsScreen.route + "/${mealEntity.mealId}")
            },
        elevation = CardDefaults.cardElevation(11.dp)
    ) {

        Box(modifier = Modifier.fillMaxSize()) {

            Box {
                AsyncImage(
                    model = mealEntity.mealImage, contentDescription = mealEntity.mealName,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxWidth()
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient( // make the gradient from top to the bottom
                            colors = listOf(
                                Color.Transparent,
                                Color.Black
                            ),
                            300f
                        )
                    )
            )

            Box(
                modifier = Modifier
                    .padding(12.dp)
                    .fillMaxSize(),
                contentAlignment = Alignment.BottomStart // the Box content position
            ) {
                Text(
                    text = mealEntity.mealName,
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 18.sp,
                        FontWeight.Bold
                    )
                )
            }

            Box(
                modifier = Modifier
                    .padding(12.dp)
                    .fillMaxSize(),
                contentAlignment = Alignment.TopEnd // the Box content position
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.filled_bookmark),
                    contentDescription = "",
                    modifier = Modifier.clickable {
                        onEvent(MealsEvents.ShowDialog)
                    }
                )
            }


        }
    }
    if (state.showHideDialog) {
        AlertMessage(onEvent = onEvent, mealEntity = mealEntity)
    }


}






