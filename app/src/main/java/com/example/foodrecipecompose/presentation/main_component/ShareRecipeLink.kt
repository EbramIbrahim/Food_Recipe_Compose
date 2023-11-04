package com.example.foodrecipecompose.presentation.main_component

import android.content.Context
import android.content.Intent
import android.content.Intent.ACTION_SEND

fun Context.shareRecipeLink(url: String) {
    // Implicit Intent
    val sendIntent = Intent(ACTION_SEND).apply {
        type = "text/plain"
        putExtra(Intent.EXTRA_TEXT, url)
    }
    val shareIntent = Intent.createChooser(
        sendIntent, null
    )
    startActivity(shareIntent)
}










