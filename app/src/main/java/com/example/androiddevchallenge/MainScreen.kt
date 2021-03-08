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
package com.example.androiddevchallenge

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Replay
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.OriginalBlue1
import com.example.androiddevchallenge.ui.theme.OriginalBlue2
import com.example.androiddevchallenge.ui.theme.OriginalBlue3

@Composable
fun MainScreen() {
    MyTheme {
        val verticalGradientBrush = Brush.verticalGradient(
            colors = listOf(
                OriginalBlue1,
                OriginalBlue2
            )
        )

        val verticalGradientBrush2 = Brush.verticalGradient(
            colors = listOf(
                OriginalBlue3,
                OriginalBlue2
            )
        )

        val viewModel: MainViewModel = viewModel()

        Surface(
            color = MaterialTheme.colors.background,
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .background(brush = verticalGradientBrush)
            ) {
                val second = viewModel.timerSecond.observeAsState()

                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Spacer(Modifier.height(8.dp))

                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .clip(CircleShape)
                            .background(Color.White)
                            .size(280.dp)
                    ) {
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .clip(CircleShape)
                                .background(verticalGradientBrush2)
                                .size(276.dp)
                        ) {
                            Row {
                                val secondValue = second.value ?: return@Row
                                CubeNumber(secondValue / 10)
                                Spacer(modifier = Modifier.width(16.dp))
                                CubeNumber(secondValue % 10)
                            }
                        }
                    }
                    Spacer(Modifier.height(8.dp))

                    FloatingActionButton(
                        onClick = { viewModel.timerStartOrStop() },
                        modifier = Modifier
                            .padding(16.dp)
                            .size(48.dp),
                        backgroundColor = MaterialTheme.colors.primary,
                        contentColor = MaterialTheme.colors.onPrimary
                    ) {
                        val state = viewModel.timerState.observeAsState()

                        Icon(
                            imageVector = if (state.value == MainViewModel.TimerState.Stop) {
                                Icons.Filled.PlayArrow
                            } else {
                                Icons.Filled.Replay
                            },
                            contentDescription = null
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun LightPreview() {
    MyTheme {
        MainScreen()
    }
}
