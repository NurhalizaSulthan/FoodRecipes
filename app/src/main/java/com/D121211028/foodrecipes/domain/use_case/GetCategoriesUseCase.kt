package com.D121211028.foodrecipes.domain.use_case

import com.D121211028.foodrecipes.domain.model.CategoryResponse
import com.D121211028.foodrecipes.domain.repository.RecipeRepository
import com.D121211028.foodrecipes.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCategoriesUseCase @Inject constructor(
    private val repository: RecipeRepository
) {

    suspend operator fun invoke(): Flow<Resource<CategoryResponse>> {
        return repository.getCategories()
    }


}
