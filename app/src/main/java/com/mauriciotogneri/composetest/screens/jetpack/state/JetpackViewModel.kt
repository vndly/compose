package com.mauriciotogneri.composetest.screens.jetpack.state

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.mauriciotogneri.composetest.repository.Repository
import com.mauriciotogneri.composetest.usercase.UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class JetpackViewModel @Inject constructor(
    useCase: UseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    var param: String by mutableStateOf(
        (savedStateHandle.get<String>("param") ?: "") + useCase.getValue()
    )
}