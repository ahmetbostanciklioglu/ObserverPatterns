package com.ahmet.observer.patterns

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class MyViewModel: ViewModel() {

    val numbersFlow : Flow<Int> = flow {
        var number = 0
        while (true) {
            emit(number++)
            delay(1000)
        }
    }

    // Alternatively, you can use MutableStateFlow to update and emit state
    private val _stateFlow = MutableStateFlow(0)
    val stateFlow: StateFlow<Int> = _stateFlow

    init {
        viewModelScope.launch {
            while (true) {
                _stateFlow.value++
                delay(1000)
            }
        }
    }

}

@Composable
fun FlowPatternScreen(viewModel: MyViewModel ) {
    val numbers by viewModel.numbersFlow.collectAsState(initial = 0)

    MyContent(numbers)

}

@Composable
fun MyContent(numbers: Int) {
    Text(text = "Numbers: $numbers")
}
