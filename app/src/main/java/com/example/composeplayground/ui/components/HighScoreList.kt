package com.example.composeplayground.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.composeplayground.DetailScreenParam
import com.example.composeplayground.data.HighScore

@Composable
fun HighScoreList(highscores : List<HighScore>,modifier: Modifier = Modifier, navController: NavController = rememberNavController()) {

    LazyColumn(modifier = modifier) {
        items(highscores) {
            ListEntry(
                data = it,
                modifier.clickable{
                    val detailScreenParam = DetailScreenParam(it.place, it.name, it.score)
                    navController.navigate(detailScreenParam)
                })
        }
    }
}


//TODO: Preview einrichten