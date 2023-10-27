package com.example.foodrecipecompose.presentation.ingredients_component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.foodrecipecompose.utils.Constant

@Composable
fun IngredientsBottomSheetScreen(
    navController: NavController
) {

    val ingredients = Constant.ingredients

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(16.dp),
        content = {
            items(ingredients.size) {
                IngredientSheetCardInfo(ingredients = ingredients[it], navController = navController)
            }
        }

    )

}











