package com.example.foodrecipecompose.presentation.ingredients_component

import androidx.compose.material.rememberBottomSheetState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.navigation.NavController


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IngredientsBottomSheet(
    navController: NavController,
    onSheetDismiss: () -> Unit
) {

    val bottomSheetState = rememberModalBottomSheetState()


    ModalBottomSheet(
        onDismissRequest = { onSheetDismiss() },
        sheetState = bottomSheetState
    ) {
        IngredientsBottomSheetScreen(navController = navController)
    }


}








