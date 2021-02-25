package com.example.androiddevchallenge.ui.home

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.model.Pup
import com.example.androiddevchallenge.model.pupsList
import com.example.androiddevchallenge.ui.components.PupListItem
import com.example.androiddevchallenge.ui.theme.PupTheme

@Composable
fun Home(pupList: List<Pup>) {
    LazyColumn {
        itemsIndexed(pupList) { _, pup ->
            PupListItem(imageUrl = pup.imageUrl, title = pup.title)
        }
    }
    Spacer(Modifier.height(8.dp))
}

@Preview
@Composable
private fun LightHome() {
    PupTheme {
        Home(pupsList)
    }
}

@Preview
@Composable
private fun DarkHome() {
    PupTheme(darkTheme = true) {
        Home(pupsList)
    }
}
