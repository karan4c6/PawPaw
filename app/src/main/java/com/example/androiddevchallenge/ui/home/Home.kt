/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
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
