package com.example.foodrecipecompose.presentation.main_component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodrecipecompose.R

@Composable
fun EmptyListScreen() {


    Column(modifier = Modifier.fillMaxSize()) {

        Image(
            painter = painterResource(id = R.drawable.recipe_empty),
            contentDescription = "",
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = "Ops!",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(2.dp))

        Text(
            text = "Your book mark list is empty, lets start add some!",
            fontSize = 16.sp,
            color = Color.White,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

    }

}








