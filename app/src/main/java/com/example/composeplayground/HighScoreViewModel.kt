package com.example.composeplayground

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.composeplayground.data.HighScore
import com.example.composeplayground.data.highScores

class HighScoreViewModel : ViewModel() {

    private val _allHighscores = MutableLiveData<List<HighScore>>(highScores)
    val allHighscores : LiveData<List<HighScore>> = _allHighscores

}