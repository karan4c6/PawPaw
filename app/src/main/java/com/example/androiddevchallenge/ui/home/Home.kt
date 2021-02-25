package com.example.androiddevchallenge.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.model.Pup
import com.example.androiddevchallenge.model.pupsList
import com.example.androiddevchallenge.ui.components.PupListItem
import com.example.androiddevchallenge.ui.theme.PupTheme

@Composable
fun Home(pupList: List<Pup>) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column {
//            PupAppBar()
            Spacer(Modifier.height(8.dp))
            LazyColumn(modifier = Modifier.align(Alignment.CenterHorizontally)) {
                itemsIndexed(pupList) { _, pup ->
                    PupListItem(imageUrl = pup.imageUrl, title = pup.name)
                    Spacer(Modifier.height(8.dp))
                }
            }
            Spacer(Modifier.height(8.dp))
        }
    }
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
