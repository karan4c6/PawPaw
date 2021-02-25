package com.example.androiddevchallenge.model

import androidx.compose.runtime.Immutable
import com.example.androiddevchallenge.R

@Immutable
data class Pup(
    val id: Long,
    val name: String,
    val imageUrl: String? = null,
    val imageId: Int? = null,
    val title: String = "",
    val description: String = "",
    val latitude: Float? = null,
    val longitude: Float? = null,
)

/**
 * Static Data
 */

val pups = listOf<Pup>(
    Pup(
        id = 1L,
        name = "Pup1",
        imageId = R.drawable.ic_launcher_foreground,
        title = "Adpot Me",
        description = "Woof Woof Demo Description"
    ),
    Pup(
        id = 2L,
        name = "Pup2",
        imageId = R.drawable.ic_launcher_foreground,
        title = "Adpot Me",
        description = "Woof Woof Demo Description"
    ),
    Pup(
        id = 3L,
        name = "Pup3",
        imageId = R.drawable.ic_launcher_foreground,
        title = "Adpot Me",
        description = "Woof Woof Demo Description"
    ),
    Pup(
        id = 4L,
        name = "Pup4",
        imageId = R.drawable.ic_launcher_foreground,
        title = "Adpot Me",
        description = "Woof Woof Demo Description"
    ),
    Pup(
        id = 5L,
        name = "Pup5",
        imageId = R.drawable.ic_launcher_foreground,
        title = "Adpot Me",
        description = "Woof Woof Demo Description"
    ),
    Pup(
        id = 6L,
        name = "Pup6",
        imageId = R.drawable.ic_launcher_foreground,
        title = "Adpot Me",
        description = "Woof Woof Demo Description"
    ),
    Pup(
        id = 7L,
        name = "Pup7",
        imageId = R.drawable.ic_launcher_foreground,
        title = "Adpot Me",
        description = "Woof Woof Demo Description"
    ),
    Pup(
        id = 8L,
        name = "Pup8",
        imageId = R.drawable.ic_launcher_foreground,
        title = "Adpot Me",
        description = "Woof Woof Demo Description"
    ),
    Pup(
        id = 9L,
        name = "Pup9",
        imageId = R.drawable.ic_launcher_foreground,
        title = "Adpot Me",
        description = "Woof Woof Demo Description"
    ),
    Pup(
        id = 10L,
        name = "Pup10",
        imageId = R.drawable.ic_launcher_foreground,
        title = "Adpot Me",
        description = "Woof Woof Demo Description"
    )
)
