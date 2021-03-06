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
package com.example.androiddevchallenge.ui.views

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.OnBackPressedDispatcher
import androidx.activity.compose.setContent
import androidx.compose.animation.Crossfade
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.core.view.WindowCompat
import com.example.androiddevchallenge.ui.components.PupDescription
import com.example.androiddevchallenge.ui.home.Home
import com.example.androiddevchallenge.ui.theme.PupTheme
import com.example.androiddevchallenge.ui.utils.Actions
import com.example.androiddevchallenge.ui.utils.Destination
import com.example.androiddevchallenge.ui.utils.LocalSysUiController
import com.example.androiddevchallenge.ui.utils.Navigator
import com.example.androiddevchallenge.ui.utils.SystemUiController
import dev.chrisbanes.accompanist.insets.ProvideWindowInsets

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            val systemUiController = remember { SystemUiController(window) }
            CompositionLocalProvider(LocalSysUiController provides systemUiController) {
                PupTheme {
                    MyApp(onBackPressedDispatcher)
                }
            }
        }
    }
}

// Start building your app here!
@Composable
fun MyApp(backDispatcher: OnBackPressedDispatcher) {

    val navigator: Navigator<Destination> = rememberSaveable(
        saver = Navigator.saver(backDispatcher)
    ) {
        Navigator(Destination.Home, backDispatcher)
    }
    val actions = remember(navigator) { Actions(navigator) }
    ProvideWindowInsets {
        Crossfade(navigator.current) { destination ->
            when (destination) {
                Destination.Home -> Home(actions.selectPup)
                is Destination.PupDetail -> PupDescription(
                    pupId = destination.pupId,
                    upPress = actions.upPress
                )
            }
        }
    }
}
