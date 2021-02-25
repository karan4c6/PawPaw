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
package com.example.androiddevchallenge.model

import androidx.compose.runtime.Immutable

@Immutable
data class Pup(
    val id: Long,
    val name: String,
    val imageUrl: String,
    val title: String = "",
    val description: String = "",
    val latitude: Float? = null,
    val longitude: Float? = null,
)

/**
 * Static Data
 */

val pupsList = listOf(
    Pup(
        id = 1L,
        name = "Pup1",
        imageUrl = "https://source.unsplash.com/9LkqymZFLrE",
        title = "Adpot Me",
        description = "Woof Woof Demo Description"
    ),
    Pup(
        id = 2L,
        name = "Pup2",
        imageUrl = "https://source.unsplash.com/sVtcRzphxbk",
        title = "Adpot Me",
        description = "Woof Woof Demo Description"
    ),
    Pup(
        id = 3L,
        name = "Pup3",
        imageUrl = "https://source.unsplash.com/DTSDD968Mpw",
        title = "Adpot Me",
        description = "Woof Woof Demo Description"
    ),
    Pup(
        id = 4L,
        name = "Pup4",
        imageUrl = "https://source.unsplash.com/NYuUoKjJR-c",
        title = "Adpot Me",
        description = "Woof Woof Demo Description"
    ),
    Pup(
        id = 5L,
        name = "Pup5",
        imageUrl = "https://source.unsplash.com/ngqyo2AYYnE",
        title = "Adpot Me",
        description = "Woof Woof Demo Description"
    ),
    Pup(
        id = 6L,
        name = "Pup6",
        imageUrl = "https://source.unsplash.com/Sg3XwuEpybU",
        title = "Adpot Me",
        description = "Woof Woof Demo Description"
    ),
    Pup(
        id = 7L,
        name = "Pup7",
        imageUrl = "https://source.unsplash.com/QZenflkkwt0",
        title = "Adpot Me",
        description = "Woof Woof Demo Description"
    ),
    Pup(
        id = 8L,
        name = "Pup8",
        imageUrl = "https://source.unsplash.com/BN6uvogY5VM",
        title = "Adpot Me",
        description = "Woof Woof Demo Description"
    ),
    Pup(
        id = 9L,
        name = "Pup9",
        imageUrl = "https://source.unsplash.com/kjcivvWaD5I",
        title = "Adpot Me",
        description = "Woof Woof Demo Description"
    ),
    Pup(
        id = 10L,
        name = "Pup10",
        imageUrl = "https://source.unsplash.com/Qb7D1xw28Co",
        title = "Adpot Me",
        description = "Woof Woof Demo Description"
    )
)
