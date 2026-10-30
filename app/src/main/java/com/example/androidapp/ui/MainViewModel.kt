package com.example.androidapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.LiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {

    private val _uiState = mutableStateOf(MainUiState())
    val uiState: State<MainUiState> = _uiState

    fun fetchData() {
        _uiState.value = _uiState.value.copy(isLoading = true)
        // TODO: вызов репозитория
        _uiState.value = _uiState.value.copy(isLoading = false)
    }
}

data class MainUiState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val data: String? = null
)