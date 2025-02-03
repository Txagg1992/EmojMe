package com.curiousapps.emojme.ui.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.curiousapps.emojme.domain.MoJiRepository
import com.curiousapps.emojme.domain.MoJis
import com.curiousapps.emojme.util.IO_DISPATCHER
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoJiListViewModel @Inject constructor(
    private val repository: MoJiRepository
) : ViewModel() {

    private val _state = MutableStateFlow(MoJiScreenState())
    val state: Flow<MoJiScreenState>
        get() = _state


    private fun fetchAllMojis() {
        viewModelScope.launch(IO_DISPATCHER) {
            val result = repository.fetchAllMojis()
            when {
                result.isSuccess -> {
                    _state.value = MoJiScreenState(
                        mojiList = result.getOrNull()!!,
                        isLoading = false
                    )
                }

                result.isFailure -> {
                    _state.value = MoJiScreenState(
                        mojiList = emptyList(),
                        isLoading = false
                    )
                }
            }
        }
    }

    data class MoJiScreenState(
        val mojiList: List<MoJis> = emptyList(),
        val isLoading: Boolean = true
    )
}