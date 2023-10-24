package com.example.foodrecipecompose.presentation.details_screen

import android.content.Context
import android.content.SharedPreferences
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.foodrecipecompose.R
import com.example.foodrecipecompose.data.local.MealEntity
import com.example.foodrecipecompose.data.model.MealDetails
import com.example.foodrecipecompose.presentation.main_component.shareRecipeLink
import com.example.foodrecipecompose.presentation.state_event.MealsEvents
import com.example.foodrecipecompose.presentation.state_event.MealsState

@Composable
fun DetailsScreen(
    mealsDetailsState: MealsState,
    context: Context,
    onEvent: (MealsEvents) -> Unit,
    mealId: String
) {

    LaunchedEffect(key1 = Unit) {
        onEvent(MealsEvents.GetMealDetails(id = mealId))
    }




    Box(modifier = Modifier.fillMaxSize()) {

        if (mealsDetailsState.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
        if (mealsDetailsState.error != null) {
            Text(
                text = "No Internet Connection....",
                color = Color.Red,
                modifier = Modifier.align(Alignment.Center),
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,

                )
        }
        val isResponseSuccessful = !mealsDetailsState.isLoading && mealsDetailsState.error == null
        if (isResponseSuccessful) {

            LazyColumn {
                items(mealsDetailsState.mealDetails.size) {
                    val mealDetails = mealsDetailsState.mealDetails[it]
                    MealImage(mealDetails = mealDetails)
                    MealDetailsScreen(mealDetails = mealDetails, onEvent, context = context)
                }
            }
        }

    }
}

@Composable
fun MealDetailsScreen(mealDetails: MealDetails, onEvent: (MealsEvents) -> Unit, context: Context) {

    var isMealSaved by remember { mutableStateOf(false) }

    val sharedPreferences: SharedPreferences = remember {
        context.getSharedPreferences("MyMeals_", Context.MODE_PRIVATE)
    }

    // default
    isMealSaved = sharedPreferences.getBoolean(mealDetails.idMeal, false)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = mealDetails.strMeal,
            color = Color.White,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )

        Text(text = mealDetails.strArea, color = Color.White)

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            ShareItems(icon = R.drawable.favorite, text = "52") { }

            ShareItems(
                icon = if (isMealSaved) R.drawable.filled_bookmark else R.drawable.outlined_bookmark,
                text = "Save",
                onItemClicked = {

                    // just recomposing the compose component
                    //only recomputes the modified components, avoiding the need to recompute the entire interface

                    if (!isMealSaved) {
                        onEvent(
                            MealsEvents.InsertMeal(
                                MealEntity(
                                    mealId = mealDetails.idMeal,
                                    mealCountry = mealDetails.strArea,
                                    mealName = mealDetails.strMeal,
                                    mealImage = mealDetails.strMealThumb
                                )
                            )
                        )
                    } else {
                        onEvent(
                            MealsEvents.DeleteMeal(
                                MealEntity(
                                    mealId = mealDetails.idMeal,
                                    mealCountry = mealDetails.strArea,
                                    mealName = mealDetails.strMeal,
                                    mealImage = mealDetails.strMealThumb
                                )
                            )
                        )
                    }

                    isMealSaved = isMealSaved.not()
                    sharedPreferences.edit().putBoolean(mealDetails.idMeal, isMealSaved).apply()

                }

            )

            ShareItems(icon = R.drawable.share, text = "Share") {
                context.shareRecipeLink(mealDetails.strYoutube)
            }

        }

        Divider()
        Spacer(modifier = Modifier.height(4.dp))


        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Text(
                text = mealDetails.strInstructions,
                fontSize = 14.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                lineHeight = 23.sp,
                overflow = TextOverflow.Visible,
            )
        }


    }
}

@Composable
fun ShareItems(
    icon: Int,
    text: String,
    onItemClicked: () -> Unit
) {
    Row(modifier = Modifier.padding(3.dp)) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = "",
            modifier = Modifier
                .clickable { onItemClicked() }
                .size(26.dp)
        )
        Text(text = text, color = Color.White)

    }
}

@Composable
fun MealImage(mealDetails: MealDetails) {


    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.4f)
    ) {

        val uriHandler = LocalUriHandler.current

        AsyncImage(
            model = mealDetails.strMealThumb,
            contentDescription = "",
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.FillWidth,
        )

        Image(
            painter = painterResource(id = R.drawable.youtube),
            contentDescription = "",
            modifier = Modifier
                .align(Alignment.Center)
                .size(64.dp)
                .clickable {
                    uriHandler.openUri(mealDetails.strYoutube)
                }
        )
    }

}











