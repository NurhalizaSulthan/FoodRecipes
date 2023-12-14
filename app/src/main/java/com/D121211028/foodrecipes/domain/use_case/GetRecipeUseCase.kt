package com.D121211028.foodrecipes.domain.use_case

import com.D121211028.foodrecipes.domain.model.RecipeDetailResponse
import com.D121211028.foodrecipes.domain.repository.RecipeRepository
import com.D121211028.foodrecipes.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetRecipeUseCase @Inject constructor(
    private val repository: RecipeRepository
) {

    suspend operator fun invoke(idMeal: String): Flow<Resource<RecipeDetailResponse>> {
        return repository.getMealById(idMeal)
    }

}