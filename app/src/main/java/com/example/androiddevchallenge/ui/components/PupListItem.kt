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

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.model.Pup
import com.example.androiddevchallenge.model.pupsList
import com.example.androiddevchallenge.ui.home.demo
import com.example.androiddevchallenge.ui.theme.PupTheme
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun PupListItem(
    pup: Pup,
    onItemClick: (Long) -> Unit
) {
    PupCard(
        elevation = 4.dp,
        shape = MaterialTheme.shapes.medium
    ) {
        Surface(modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .clickable {
                onItemClick(pup.id)
            }) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.wrapContentSize()
            ) {
                Surface(
                    elevation = 8.dp,
                    modifier = Modifier.size(200.dp),
                    shape = CircleShape,
                    color = MaterialTheme.colors.surface.copy(alpha = 0.2f)
                ) {
                    CoilImage(
                        data = pup.imageUrl,
                        contentDescription = pup.description,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize(),
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
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = pup.description,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.subtitle1,
                    color = MaterialTheme.colors.onSecondary,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            }
        }
    }
}

@Preview("Light Theme", showBackground = true)
@Composable
fun LightThemePupListItem() {
    PupTheme {
        PupListItem(pupsList[0], ::demo)
    }
}

@Preview("Dark Theme")
@Composable
fun DarkThemePupListItem() {
    PupTheme(darkTheme = true) {
        PupListItem(pupsList[0], ::demo)
    }
}
