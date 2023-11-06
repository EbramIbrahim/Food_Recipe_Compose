package com.example.foodrecipecompose.presentation.main_component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.foodrecipecompose.data.model.Meal
import com.example.foodrecipecompose.presentation.state_event.MealsState
import com.example.foodrecipecompose.utils.Screen


@Composable
fun RandomMealScreen(
    state: MealsState,
    navController: NavController
) {

    Column {
            Column(modifier = Modifier.padding(8.dp)) {
                Text(
                    text = "Daily Inspiration",
                    color = Color.White,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(10.dp))

                LazyRow(contentPadding = PaddingValues(11.dp)) {
                    items(state.allMeals.size) {
                        RandomMealCardInfo(meal = state.allMeals[it], navController)
                    }

                }

            }



    }


}


@Composable
fun RandomMealCardInfo(
    meal: Meal,
    navController: NavController
) {


    Card(
        modifier = Modifier
            .width(260.dp)
            .height(260.dp)
            .clip(RoundedCornerShape(16.dp))
            .padding(end = 12.dp, top = 12.dp)
            .clickable {
                navController.navigate(Screen.MealDetailsScreen.route + "/${meal.idMeal}")
            },
        elevation = CardDefaults.cardElevation(11.dp)
    ) {

        Box(modifier = Modifier.fillMaxSize()) {

            Box {
                AsyncImage(
                    model = meal.strMealThumb, contentDescription = meal.strMeal,
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
                    text = meal.strMeal,
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 18.sp,
                        FontWeight.Bold
                    )
                )
            }
        }


    }


}

























