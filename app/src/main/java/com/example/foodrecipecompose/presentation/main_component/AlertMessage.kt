package com.example.foodrecipecompose.presentation.main_component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.foodrecipecompose.data.local.MealEntity
import com.example.foodrecipecompose.presentation.state_event.MealsEvents

@Composable
fun AlertMessage(
    onEvent: (MealsEvents) -> Unit,
    mealEntity: MealEntity,
) {

    AlertDialog(

        onDismissRequest = {
            onEvent(MealsEvents.HideDialog)
        },

        title = { Text(text = "Delete Meal") },

        text = { Text(text = "Do you want to delete this meal") },

        dismissButton = {
                Button(onClick = {
                    onEvent(MealsEvents.HideDialog)
                }) {
                    Text(text = "Cancel")
                }
        },

        confirmButton = {
                Button(onClick = {
                    onEvent(MealsEvents.DeleteMeal(mealEntity))
                    onEvent(MealsEvents.HideDialog)
                }) {
                    Text(text = "Confirm")
                }
        },

    )

}









