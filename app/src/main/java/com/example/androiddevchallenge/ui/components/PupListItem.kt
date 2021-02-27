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
package com.example.androiddevchallenge.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.model.Pup
import com.example.androiddevchallenge.model.pupsList
import com.example.androiddevchallenge.ui.theme.PupTheme
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun PupListItem(
    pup: Pup,
    onItemClick: (Long) -> Unit
) {
    PupCard(
        elevation = 4.dp,
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier.semantics {
            contentDescription = "Puppy ${pup.title} ${pup.description} Double Tap for More Details"
        }
    ) {
        Surface(modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .clearAndSetSemantics { }
            .clickable {
                onItemClick(pup.id)
            }) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.wrapContentSize()
            ) {
                PupSurface(
                    modifier = Modifier
                        .size(200.dp)
                        .clearAndSetSemantics { },
                    color = Color.LightGray,
                    elevation = 4.dp,
                    shape = CircleShape,
                ) {
                    CoilImage(
                        data = pup.imageUrl,
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxSize()
                            .clearAndSetSemantics { },
                        loading = {
                            Box(Modifier.matchParentSize()) {
                                CircularProgressIndicator(Modifier.align(Alignment.Center))
                            }
                        }
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = pup.title,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.h6,
                    color = MaterialTheme.colors.onSecondary,
                    modifier = Modifier.clearAndSetSemantics { }
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = pup.description,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.subtitle1,
                    color = MaterialTheme.colors.onSecondary,
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                        .clearAndSetSemantics { }
                )
            }
        }
    }
}

@Preview("Light Theme", showBackground = true)
@Composable
fun LightThemePupListItem() {
    PupTheme {
        PupListItem(
            pupsList[0]
        ) {}
    }
}

@Preview("Dark Theme")
@Composable
fun DarkThemePupListItem() {
    PupTheme(darkTheme = true) {
        PupListItem(pupsList[0]) {}
    }
}
