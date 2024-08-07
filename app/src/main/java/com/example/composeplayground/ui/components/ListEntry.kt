package com.example.composeplayground.ui.components

import android.view.Surface
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import androidx.compose.material3.Surface
import androidx.compose.ui.unit.sp
import com.example.composeplayground.data.HighScore


@Composable
fun ListEntry(data: HighScore ,modifier: Modifier = Modifier) {

    ListItem(
        modifier = modifier,
        headlineContent = {
            Text(text = data.name)
        },
        leadingContent = {
            Text(text = "${data.place}.")
        },
        trailingContent = {
            Text(text = "${data.score}")
        }
    )

}


@Preview
@Composable
private fun ListEntryPreview() {

    val exampleHighScore = HighScore(4, "Lars", 500)

    Surface {
        ListEntry(data = exampleHighScore)
    }

}