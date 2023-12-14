package com.D121211028.foodrecipes.domain.use_case

import com.D121211028.foodrecipes.domain.model.RecipesResponse
import com.D121211028.foodrecipes.domain.repository.RecipeRepository
import com.D121211028.foodrecipes.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetRecipesUseCase @Inject constructor(
    private val repository: RecipeRepository
) {

    suspend operator fun invoke(strCategory: String): Flow<Resource<RecipesResponse>> {
        return repository.getMealsByCategory(strCategory)
    }
}