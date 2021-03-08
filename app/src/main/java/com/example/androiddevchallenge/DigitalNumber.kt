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

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.DigitalOff
import com.example.androiddevchallenge.ui.theme.DigitalOn

@Composable
fun DigitalNumber(number: Int) {
    LazyColumn {
        for (y in 0 until 7) {
            item {
                LazyRow {
                    for (x in 0 until 5) {
                        item {
                            val pixel = NUMBERS[number][5 * y + x]

                            val backgroundColors by animateColorAsState(
                                targetValue = if (pixel == 1) DigitalOn else DigitalOff,
                                animationSpec = tween(2000)
                            )

                            Box(
                                modifier = Modifier
                                    .size(12.dp)
                                    .clip(RoundedCornerShape(3.dp))
                                    .background(backgroundColors)
                            )
                            Spacer(modifier = Modifier.width(1.dp))
                        }
                    }
                }
                Spacer(modifier = Modifier.height(1.dp))
            }
        }
    }
}

val NUMBERS = listOf(
    // 0
    listOf(
        0, 1, 1, 1, 0,
        1, 0, 0, 0, 1,
        1, 0, 0, 1, 1,
        1, 0, 1, 0, 1,
        1, 1, 0, 0, 1,
        1, 0, 0, 0, 1,
        0, 1, 1, 1, 0,
    ),
    // 1
    listOf(
        0, 0, 0, 1, 0,
        0, 0, 1, 1, 0,
        0, 0, 0, 1, 0,
        0, 0, 0, 1, 0,
        0, 0, 0, 1, 0,
        0, 0, 0, 1, 0,
        0, 0, 1, 1, 1,
    ),
    // 2
    listOf(
        0, 1, 1, 1, 0,
        1, 0, 0, 0, 1,
        0, 0, 0, 0, 1,
        0, 0, 0, 1, 0,
        0, 0, 1, 0, 0,
        0, 1, 0, 0, 0,
        1, 1, 1, 1, 1,
    ),
    // 3
    listOf(
        0, 1, 1, 1, 0,
        1, 0, 0, 0, 1,
        0, 0, 0, 0, 1,
        0, 0, 1, 1, 0,
        0, 0, 0, 0, 1,
        1, 0, 0, 0, 1,
        0, 1, 1, 1, 0,
    ),
    // 4
    listOf(
        0, 0, 0, 1, 0,
        0, 0, 1, 1, 0,
        0, 1, 0, 1, 0,
        1, 0, 0, 1, 0,
        1, 1, 1, 1, 1,
        0, 0, 0, 1, 0,
        0, 0, 0, 1, 0,
    ),
    // 5
    listOf(
        1, 1, 1, 1, 1,
        1, 0, 0, 0, 0,
        1, 1, 1, 1, 0,
        0, 0, 0, 0, 1,
        0, 0, 0, 0, 1,
        1, 0, 0, 0, 1,
        0, 1, 1, 1, 0,
    ),
    // 6
    listOf(
        0, 1, 1, 1, 0,
        1, 0, 0, 0, 1,
        1, 0, 0, 0, 0,
        1, 1, 1, 1, 0,
        1, 0, 0, 0, 1,
        1, 0, 0, 0, 1,
        0, 1, 1, 1, 0,
    ),
    // 7
    listOf(
        1, 1, 1, 1, 1,
        0, 0, 0, 0, 1,
        0, 0, 0, 1, 0,
        0, 0, 1, 0, 0,
        0, 0, 1, 0, 0,
        0, 0, 1, 0, 0,
        0, 0, 1, 0, 0,
    ),
    // 8
    listOf(
        0, 1, 1, 1, 0,
        1, 0, 0, 0, 1,
        1, 0, 0, 0, 1,
        0, 1, 1, 1, 0,
        1, 0, 0, 0, 1,
        1, 0, 0, 0, 1,
        0, 1, 1, 1, 0,
    ),
    // 9
    listOf(
        0, 1, 1, 1, 0,
        1, 0, 0, 0, 1,
        1, 0, 0, 0, 1,
        0, 1, 1, 1, 1,
        0, 0, 0, 0, 1,
        1, 0, 0, 0, 1,
        0, 1, 1, 1, 0,
    ),
)

@Preview("0")
@Composable
fun NumberZeroPreview() {
    DigitalNumber(0)
}

@Preview("1")
@Composable
fun NumberOnePreview() {
    DigitalNumber(1)
}

@Preview("2")
@Composable
fun NumberTwoPreview() {
    DigitalNumber(2)
}

@Preview("3")
@Composable
fun NumberThreePreview() {
    DigitalNumber(3)
}

@Preview("4")
@Composable
fun NumberFourPreview() {
    DigitalNumber(4)
}

@Preview("5")
@Composable
fun NumberFivePreview() {
    DigitalNumber(5)
}

@Preview("6")
@Composable
fun NumberSixPreview() {
    DigitalNumber(6)
}

@Preview("7")
@Composable
fun NumberSevenPreview() {
    DigitalNumber(7)
}

@Preview("8")
@Composable
fun NumberEightPreview() {
    DigitalNumber(8)
}

@Preview("9")
@Composable
fun NumberNinePreview() {
    DigitalNumber(9)
}
