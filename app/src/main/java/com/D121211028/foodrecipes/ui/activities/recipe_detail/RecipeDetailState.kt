package com.D121211028.foodrecipes.ui.activities.recipe_detail

import com.D121211028.foodrecipes.domain.model.RecipeDetail

data class RecipeDetailState(
    val isLoading: Boolean = false,
    val meals: List<RecipeDetail> = emptyList(),
    val error: String = ""
)