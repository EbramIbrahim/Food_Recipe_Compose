package com.example.foodrecipecompose.presentation.country_screen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.foodrecipecompose.data.model.Country
import com.example.foodrecipecompose.utils.Constant
import com.example.foodrecipecompose.utils.Screen

@Composable
fun CountriesList(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.DarkGray)
    )
    {

        Text(
            text = "Explore Countries Popular Foods",
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(10.dp))

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            val countries = Constant.countries
            items(countries.size) {
                CountryCardInfo(country = countries[it], navController = navController)
            }
        }


    }
}


@SuppressLint("ResourceType")
@Composable
fun CountryCardInfo(country: Country, navController: NavController) {


    Box(
        modifier = Modifier
            .width(100.dp)
            .height(100.dp)
            .clip(RoundedCornerShape(22.dp))
            .clickable { navController.navigate(Screen.CountryScreen.route + "/${country.countryName}") },
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = country.countryFlag),
                contentDescription = country.countryName,
                contentScale = ContentScale.Fit,
                modifier = Modifier.size(70.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = country.countryName,
                color = Color.White,
                fontSize = 14.sp,
                fontWeight = FontWeight.Light
            )
        }


    }
}



