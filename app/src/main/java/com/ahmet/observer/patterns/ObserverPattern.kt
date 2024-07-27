package com.ahmet.observer.patterns

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ObserverViewModel : ViewModel() {
    private val _uiState = MutableStateFlow("Initial State")
    val uiState: StateFlow<String> = _uiState

    fun updateState(newState: String) {
        _uiState.value = newState
    }
}

@Composable
fun ObserverPatternScreen(viewModel: ObserverViewModel) {

    val uiState by viewModel.uiState.collectAsState()

    MyObserverContent(uiState)
}

@Composable
fun MyObserverContent(uiState: String) {
    // UI content
    Text(uiState)
}