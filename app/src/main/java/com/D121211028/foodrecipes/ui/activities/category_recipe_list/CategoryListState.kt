package com.D121211028.foodrecipes.ui.activities.category_recipe_list

import com.D121211028.foodrecipes.domain.model.Category

data class CategoryListState(
    val isLoading: Boolean = false,
    val categories: List<Category> = emptyList(),
    val error: String = ""
)