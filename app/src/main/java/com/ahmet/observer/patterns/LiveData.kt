package com.ahmet.observer.patterns

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LiveDataViewModel : ViewModel() {
    private val _text = MutableLiveData("Hello, LiveData in Jetpack Compose!")
    val text: LiveData<String> = _text
}

@Composable
fun LiveDataPatternScreen(liveDataViewModel: LiveDataViewModel) {
    val text by liveDataViewModel.text.observeAsState(initial = "")

    TextDisplay(text = text)
}

@Composable
fun TextDisplay(text: String) {
    Text(text = text)
}