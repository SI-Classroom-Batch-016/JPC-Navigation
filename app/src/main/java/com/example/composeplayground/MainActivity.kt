package com.example.composeplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.composeplayground.data.HighScore
import com.example.composeplayground.ui.components.HighScoreList
import com.example.composeplayground.ui.components.ListEntry
import com.example.composeplayground.ui.components.screens.DetailScreen
import com.example.composeplayground.ui.components.screens.ListScreen
import com.example.composeplayground.ui.theme.ComposePlaygroundTheme
import kotlinx.serialization.Serializable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val viewModel: HighScoreViewModel = viewModel()
            val navController = rememberNavController()
            val highScores by viewModel.allHighscores.observeAsState()

            ComposePlaygroundTheme {

                Scaffold { contentPadding ->

                    NavHost(navController = navController, startDestination = ListScreenParam) {

                        //Screen Definitionen
                        composable<ListScreenParam> {

                            ListScreen(modifier = Modifier.padding(contentPadding), navController = navController)

                        }

                        composable<DetailScreenParam> {
                            val screenParam = it.toRoute<DetailScreenParam>()
                            val (place, name, score) = screenParam
                            val highScore = HighScore(place, name, score)

                            DetailScreen(
                                highScore = highScore,
                                modifier = Modifier.padding(contentPadding).fillMaxSize(),
                                navController = navController)
                        }
                    }
                }
            }
        }
    }
}

@Serializable
data object ListScreenParam

@Serializable
data class DetailScreenParam(
    val place: Int,
    val name: String,
    val score: Int,
)


@Preview
@Composable
private fun ListPreview() {

    val exampleData = (1..100).toList()

    Surface(modifier = Modifier.fillMaxSize()) {

        LazyColumn {
//            items(exampleData) {
//                ListEntry(data = it, modifier = Modifier.padding(4.dp))
//            }

        }


    }


}




