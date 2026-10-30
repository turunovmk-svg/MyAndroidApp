package com.example.androidapp

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.example.androidapp.ui.theme.AndroidAppTheme
import com.example.androidapp.ui.screens.MainScreen
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, true)

        viewModel.uiState.onEach { state ->
            // обработка состояния
        }.launchIn(lifecycleScope)

        // Используй Compose или XML-разметку — выбери один подход.
        // Ниже пример с XML-разметкой.
        setContentView(R.layout.activity_main)
    }
}