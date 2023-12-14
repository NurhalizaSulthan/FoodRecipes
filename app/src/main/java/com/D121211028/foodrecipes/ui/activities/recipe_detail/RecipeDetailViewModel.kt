package com.D121211028.foodrecipes.ui.activities.recipe_detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.D121211028.foodrecipes.domain.use_case.ApiUseCases
import com.D121211028.foodrecipes.util.Constants.PARAM_ID_MEAL
import com.D121211028.foodrecipes.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipeDetailViewModel @Inject constructor(
    private val apiUseCases: ApiUseCases,
    savedStateHandle: SavedStateHandle
): ViewModel() {

    private val _state = MutableStateFlow(RecipeDetailState())
    val state: StateFlow<RecipeDetailState> = _state.asStateFlow()

    init {
        viewModelScope.launch {
            savedStateHandle.get<String>(PARAM_ID_MEAL)?.let { idMeal ->
                getMeal(idMeal)
            }
        }
    }

    private suspend fun getMeal(idMeal: String) {
        apiUseCases.getMealUseCase(idMeal).onEach { result ->
            when(result) {
                is Resource.Success -> {
                    _state.value = RecipeDetailState(
                        meals = result.data?.meals ?: emptyList()
                    )
                }
                is Resource.Error -> {
                    _state.value = RecipeDetailState(
                        error = result.message ?: "Terjadi kesalahan tak terduga"
                    )
                }
                is Resource.Loading -> {
                    _state.value = RecipeDetailState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}