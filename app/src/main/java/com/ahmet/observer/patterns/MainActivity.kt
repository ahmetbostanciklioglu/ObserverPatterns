package com.ahmet.observer.patterns

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.ahmet.observer.patterns.ui.theme.ObserverPatternsTheme

class MainActivity : ComponentActivity() {

    private val viewModel: LiveDataViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ObserverPatternsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {

                        LiveDataPatternScreen(viewModel)

                        //ObserverPatternScreen(viewModel) ---> Update viewModel type according to the screen

                        //FlowPatternScreen(viewModel) ---> Update viewModel type according to the screen
                    }
                }
            }
        }
    }
}

