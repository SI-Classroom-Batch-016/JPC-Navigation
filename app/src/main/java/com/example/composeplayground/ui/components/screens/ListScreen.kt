package com.example.composeplayground.ui.components.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.composeplayground.HighScoreViewModel
import com.example.composeplayground.ui.components.HighScoreList

@Composable
fun ListScreen(modifier: Modifier = Modifier, navController: NavController = rememberNavController()) {

    val viewModel: HighScoreViewModel = viewModel()
    val highscores by viewModel.allHighscores.observeAsState()

    HighScoreList(highscores = highscores!!, modifier = modifier, navController = navController)

}