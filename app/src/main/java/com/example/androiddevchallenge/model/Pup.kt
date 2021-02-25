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
        imageUrl = "https://source.unsplash.com/UsSdMZ78Q3E",
        title = "Adpot Me",
        description = "Woof Woof Demo Description"
    ),
    Pup(
        id = 2L,
        name = "Pup2",
        imageUrl = "https://source.unsplash.com/UsSdMZ78Q3E",
        title = "Adpot Me",
        description = "Woof Woof Demo Description"
    ),
    Pup(
        id = 3L,
        name = "Pup3",
        imageUrl = "https://source.unsplash.com/UsSdMZ78Q3E",
        title = "Adpot Me",
        description = "Woof Woof Demo Description"
    ),
    Pup(
        id = 4L,
        name = "Pup4",
        imageUrl = "https://source.unsplash.com/UsSdMZ78Q3E",
        title = "Adpot Me",
        description = "Woof Woof Demo Description"
    ),
    Pup(
        id = 5L,
        name = "Pup5",
        imageUrl = "https://source.unsplash.com/UsSdMZ78Q3E",
        title = "Adpot Me",
        description = "Woof Woof Demo Description"
    ),
    Pup(
        id = 6L,
        name = "Pup6",
        imageUrl = "https://source.unsplash.com/UsSdMZ78Q3E",
        title = "Adpot Me",
        description = "Woof Woof Demo Description"
    ),
    Pup(
        id = 7L,
        name = "Pup7",
        imageUrl = "https://source.unsplash.com/UsSdMZ78Q3E",
        title = "Adpot Me",
        description = "Woof Woof Demo Description"
    ),
    Pup(
        id = 8L,
        name = "Pup8",
        imageUrl = "https://source.unsplash.com/UsSdMZ78Q3E",
        title = "Adpot Me",
        description = "Woof Woof Demo Description"
    ),
    Pup(
        id = 9L,
        name = "Pup9",
        imageUrl = "https://source.unsplash.com/UsSdMZ78Q3E",
        title = "Adpot Me",
        description = "Woof Woof Demo Description"
    ),
    Pup(
        id = 10L,
        name = "Pup10",
        imageUrl = "https://source.unsplash.com/UsSdMZ78Q3E",
        title = "Adpot Me",
        description = "Woof Woof Demo Description"
    )
)
