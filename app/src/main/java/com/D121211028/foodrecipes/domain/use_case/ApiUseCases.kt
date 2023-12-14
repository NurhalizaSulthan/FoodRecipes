package com.D121211028.foodrecipes.domain.use_case

data class ApiUseCases(
    val getCategoriesUseCase: GetCategoriesUseCase,
    val getMealsUseCase: GetRecipesUseCase,
    val getMealUseCase: GetRecipeUseCase
)