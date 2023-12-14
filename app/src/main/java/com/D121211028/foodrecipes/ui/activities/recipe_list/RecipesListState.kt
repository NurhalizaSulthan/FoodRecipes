package com.D121211028.foodrecipes.ui.activities.recipe_list

import com.D121211028.foodrecipes.domain.model.Recipes

data class RecipesListState(
    val isLoading: Boolean = false,
    val meals: List<Recipes> = emptyList(),
    val error: String = ""
)