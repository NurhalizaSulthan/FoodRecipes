package com.D121211028.foodrecipes.ui.activities.category_recipe_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.D121211028.foodrecipes.domain.use_case.ApiUseCases
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
class CategoryListViewModel @Inject constructor(
    private val apiUseCases: ApiUseCases
): ViewModel() {

    private val _state = MutableStateFlow(CategoryListState())
    val state: StateFlow<CategoryListState> = _state.asStateFlow()

    init {
        viewModelScope.launch {
            getCategories()
        }
    }

    private suspend fun getCategories() {
        apiUseCases.getCategoriesUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = CategoryListState(
                        categories = result.data!!.categories
                    )
                }
                is Resource.Error -> {
                    _state.value = CategoryListState(
                        error = result.message ?: "Terjadi kesalahan yang tidak terduga"
                    )
                }
                is Resource.Loading -> {
                    _state.value = CategoryListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

}