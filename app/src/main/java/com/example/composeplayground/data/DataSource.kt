package com.example.composeplayground.data

import kotlinx.serialization.Serializable

@Serializable
data class HighScore(

    val place: Int,
    val name: String,
    val score: Int,

)

val highScores = listOf(
    HighScore(1, "Mehrdad", 800),
    HighScore(2, "Lisis", 700),
    HighScore(3, "Kevin", 500),
    HighScore(4, "Jonas H.", 400),
    HighScore(5, "Jonas G.", 350),
    HighScore(6, "Moritz", 280),
    HighScore(7, "Dominik", 100),
)