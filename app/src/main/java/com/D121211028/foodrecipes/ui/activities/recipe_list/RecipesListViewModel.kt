package com.D121211028.foodrecipes.ui.activities.recipe_list

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.D121211028.foodrecipes.util.Constants.PARAM_STR_CATEGORY
import com.D121211028.foodrecipes.util.Resource
import com.D121211028.foodrecipes.domain.use_case.ApiUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipesListViewModel @Inject constructor(
    private val apiUseCases: ApiUseCases,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = MutableStateFlow(RecipesListState())
    val state: StateFlow<RecipesListState> = _state.asStateFlow()

    init {
        viewModelScope.launch {
            savedStateHandle.get<String>(PARAM_STR_CATEGORY)?.let { strCategory ->
                getMeals(strCategory)
            }
        }
    }

    private suspend fun getMeals(strCategory: String)                                         {
        apiUseCases.getMealsUseCase(strCategory).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = RecipesListState(
                        meals = result.data?.meals ?: emptyList()
                    )
                }
                is Resource.Error -> {
                    _state.value = RecipesListState(
                        error = result.message ?: "Terjadi kesalahan yang tidak terduga."
                    )
                }
                is Resource.Loading -> {
                    _state.value = RecipesListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}