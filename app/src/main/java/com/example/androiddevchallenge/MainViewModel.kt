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

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {

    enum class TimerState {
        Start,
        Stop
    }

    private val _timerSecond: MutableLiveData<Int> = MutableLiveData(60)
    val timerSecond: LiveData<Int>
        get() = _timerSecond

    private val _timerState: MutableLiveData<TimerState> = MutableLiveData(TimerState.Stop)
    val timerState: LiveData<TimerState>
        get() = _timerState

    private var job: Job? = null

    fun timerStartOrStop() {
        if (_timerState.value != TimerState.Stop) {
            _timerState.value = TimerState.Stop
            _timerSecond.value = 60
            job?.cancel()
            return
        }
        job = viewModelScope.launch {
            _timerState.value = TimerState.Start
            var second = 60

            while (isActive) {
                second--
                if (second < 0) {
                    _timerState.value = TimerState.Stop
                    job?.cancel()
                    break
                } else {
                    _timerSecond.value = second
                }
                delay(1000L)
            }
        }
    }
}
