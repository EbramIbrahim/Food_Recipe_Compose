package com.example.foodrecipecompose.presentation.main_component

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.foodrecipecompose.data.model.Ingredients
import com.example.foodrecipecompose.utils.Constant
import com.example.foodrecipecompose.utils.Screen


@Composable
fun IngredientsScreen(
    navController: NavController
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.DarkGray)
            .padding(11.dp)

    ) {

        Text(
            text = "Quick Search by Ingredients",
            fontSize = 16.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(12.dp))

        Row(
            modifier = Modifier
                .padding(start = 4.dp, end = 8.dp, top = 8.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            (0..3).forEach {
                val ingredients = Constant.ingredients[it]
                IngredientsCard(
                    ingredients = ingredients,
                    navController = navController
                )
            }
        }

        Spacer(modifier = Modifier.height(4.dp))

        Row(
            modifier = Modifier
                .padding(start = 4.dp, end = 8.dp, top = 8.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            (4..7).forEach {
                val ingredients = Constant.ingredients[it]
                IngredientsCard(
                    ingredients = ingredients,
                    navController = navController
                )
            }
        }


        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(11.dp)
                .clip(RoundedCornerShape(6.dp))
        ) {
            Text(
                text = "See All Ingredients",
                color = Color.Black,
                fontWeight = FontWeight.Light
            )
        }


    }
}


@SuppressLint("ResourceType")
@Composable
fun IngredientsCard(ingredients: Ingredients, navController: NavController) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .clip(CircleShape)
                .background(colorResource(id = ingredients.color))
                .size(65.dp)
                .clickable {
                    navController.navigate(Screen.SearchScreen.route + "/${ingredients.name}")
                },
            contentAlignment = Alignment.Center
        ) {

            Image(
                painter = painterResource(id = ingredients.image),
                contentDescription = ingredients.name,
                contentScale = ContentScale.Fit,
                modifier = Modifier.size(50.dp)
            )

        }

        Text(
            text = ingredients.name,
            fontSize = 14.sp,
            fontWeight = FontWeight.Light,
            color = Color.White
        )
    }


}

//@Preview
//@Composable
//fun Preview() {
//    val ingredients = Constant.ingredients
//    LazyColumn {
//        items(ingredients.size) {
//            IngredientsCard(ingredients = ingredients[it])
//        }
//    }
//}









