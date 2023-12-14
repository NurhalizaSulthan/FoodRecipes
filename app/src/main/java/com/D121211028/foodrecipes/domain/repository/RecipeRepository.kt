package com.D121211028.foodrecipes.domain.repository

import com.D121211028.foodrecipes.domain.model.CategoryResponse
import com.D121211028.foodrecipes.domain.model.RecipeDetailResponse
import com.D121211028.foodrecipes.domain.model.RecipesResponse
import com.D121211028.foodrecipes.util.Resource
import kotlinx.coroutines.flow.Flow

interface RecipeRepository {

    suspend fun getCategories(): Flow<Resource<CategoryResponse>>

    suspend fun getMealsByCategory(strCategory: String): Flow<Resource<RecipesResponse>>

    suspend fun getMealById(idMeal: String): Flow<Resource<RecipeDetailResponse>>

}