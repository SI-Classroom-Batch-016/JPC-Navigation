package com.example.composeplayground.ui.components.screens

import androidx.compose.foundation.clickable
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.composeplayground.ListScreenParam
import com.example.composeplayground.data.HighScore
import com.example.composeplayground.ui.components.ListEntry

@Composable
fun DetailScreen(highScore : HighScore, modifier: Modifier = Modifier, navController: NavController = rememberNavController()) {

    Surface(modifier = modifier.clickable { navController.navigate(ListScreenParam) }) {

    ListEntry(data = highScore)
    }

}