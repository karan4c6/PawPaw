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
    val imageUrl: String,
    val title: String,
    val description: String,
    val pupDetail: PupDetail
)

@Immutable
data class PupDetail(
    val gender: String,
    val breed: String,
    val color: String,
    val age: String,
    val desexed: Boolean = false,
    val location: String,
    val adoptionFee: String,
    val microChipped: Boolean = false,
    val wormed: Boolean = false,
    val vetChecked: Boolean = false
)

/**
 * Static Data
 */
val pupsList = listOf(
    Pup(
        id = 1L,
        imageUrl = "https://source.unsplash.com/9LkqymZFLrE",
        title = "Archie",
        description = "Medium Male Dog",
        pupDetail = PupDetail(
            gender = "Male",
            breed = "Labrador",
            color = "Black",
            age = "3 weeks",
            desexed = false,
            location = "Sydney, NSW",
            adoptionFee = "$218.00",
            microChipped = false,
            wormed = true,
            vetChecked = false
        )
    ),
    Pup(
        id = 2L,
        imageUrl = "https://source.unsplash.com/sVtcRzphxbk",
        title = "Krispy",
        description = "Friendly to people",
        pupDetail = PupDetail(
            gender = "Female",
            breed = "Labrador",
            color = "Black",
            age = "2 weeks",
            desexed = false,
            location = "Melbourne, VIC",
            adoptionFee = "$194.00",
            microChipped = false,
            wormed = true,
            vetChecked = false
        )
    ),
    Pup(
        id = 3L,
        imageUrl = "https://source.unsplash.com/DTSDD968Mpw",
        title = "Jagger",
        description = "Astoundingly clean",
        pupDetail = PupDetail(
            gender = "Male",
            breed = "Labrador",
            color = "Black",
            age = "2 weeks",
            desexed = false,
            location = "Brisbane, QLD",
            adoptionFee = "$179.00",
            microChipped = false,
            wormed = true,
            vetChecked = false
        )
    ),
    Pup(
        id = 4L,
        imageUrl = "https://source.unsplash.com/NYuUoKjJR-c",
        title = "Rocky",
        description = "cute but stupid",
        pupDetail = PupDetail(
            gender = "Male",
            breed = "Labrador",
            color = "Black",
            age = "2 weeks",
            desexed = false,
            location = "Byron Bay, NSW",
            adoptionFee = "$128.00",
            microChipped = false,
            wormed = true,
            vetChecked = false
        )
    ),
    Pup(
        id = 5L,
        imageUrl = "https://source.unsplash.com/ngqyo2AYYnE",
        title = "Jupiter",
        description = "roly-poly",
        pupDetail = PupDetail(
            gender = "Male",
            breed = "Labrador",
            color = "Black",
            age = "4 weeks",
            desexed = false,
            location = "Byron Bay, QLD",
            adoptionFee = "$325.00",
            microChipped = false,
            wormed = true,
            vetChecked = false
        )
    ),
    Pup(
        id = 6L,
        imageUrl = "https://source.unsplash.com/Sg3XwuEpybU",
        title = "Sydney",
        description = "Woof Woof Demo Description",
        pupDetail = PupDetail(
            gender = "Female",
            breed = "Labrador",
            color = "Black",
            age = "2 weeks",
            desexed = false,
            location = "Byron Bay, QLD",
            adoptionFee = "$190.00",
            microChipped = false,
            wormed = true,
            vetChecked = false
        )
    ),
    Pup(
        id = 7L,
        imageUrl = "https://source.unsplash.com/QZenflkkwt0",
        title = "Simba",
        description = "angelic black",
        pupDetail = PupDetail(
            gender = "Male",
            breed = "Labrador",
            color = "Black",
            age = "2 weeks",
            desexed = false,
            location = "Byron Bay, QLD",
            adoptionFee = "$215.00",
            microChipped = false,
            wormed = true,
            vetChecked = false
        )
    ),
    Pup(
        id = 8L,
        imageUrl = "https://source.unsplash.com/BN6uvogY5VM",
        title = "Jewel",
        description = "playful and foolish",
        pupDetail = PupDetail(
            gender = "Female",
            breed = "Labrador",
            color = "Black",
            age = "2 weeks",
            desexed = false,
            location = "Sydney, NSW",
            adoptionFee = "$100.10",
            microChipped = false,
            wormed = true,
            vetChecked = false
        )
    ),
    Pup(
        id = 9L,
        imageUrl = "https://source.unsplash.com/kjcivvWaD5I",
        title = "Ziggy",
        description = "furry half-grown",
        pupDetail = PupDetail(
            gender = "Male",
            breed = "Labrador",
            color = "Black",
            age = "2 weeks",
            desexed = false,
            location = "Wollongong, NSW",
            adoptionFee = "$125.00",
            microChipped = false,
            wormed = true,
            vetChecked = false
        )
    ),
    Pup(
        id = 10L,
        imageUrl = "https://source.unsplash.com/Qb7D1xw28Co",
        title = "Tommy",
        description = "young and nervous",
        pupDetail = PupDetail(
            gender = "Male",
            breed = "Labrador",
            color = "Black",
            age = "2 weeks",
            desexed = false,
            location = "Blue Mountains, NSW",
            adoptionFee = "$220.00",
            microChipped = false,
            wormed = true,
            vetChecked = false
        )
    )
)
