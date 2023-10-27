package com.example.foodrecipecompose.presentation.ingredients_component

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.foodrecipecompose.data.model.Ingredients
import com.example.foodrecipecompose.utils.Screen

@SuppressLint("ResourceType")
@Composable
fun IngredientSheetCardInfo(
    ingredients: Ingredients,
    navController: NavController
) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(8.dp)
    ) {


        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(11.dp))
                .size(100.dp)
                .background(colorResource(id = ingredients.color))
                .clickable {
                    navController.navigate(Screen.SearchScreen.route + "/${ingredients.name}")
                },
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = ingredients.image),
                contentDescription = ingredients.name,
                contentScale = ContentScale.Fit,
                modifier = Modifier.size(70.dp)
            )
        }

        Text(
            text = ingredients.name,
            fontSize = 16.sp,
            fontWeight = FontWeight.Light,
            color = Color.White
        )

    }


}







