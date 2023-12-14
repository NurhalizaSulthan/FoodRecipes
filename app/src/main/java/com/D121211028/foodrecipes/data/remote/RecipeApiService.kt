package com.D121211028.foodrecipes.data.remote

import com.D121211028.foodrecipes.domain.model.CategoryResponse
import com.D121211028.foodrecipes.domain.model.RecipeDetailResponse
import com.D121211028.foodrecipes.domain.model.RecipesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface RecipeApiService {

    @GET("categories.php")
    suspend fun getCategories(): CategoryResponse

    @GET("filter.php")
    suspend fun getMealsByCategory(@Query("c") strCategory: String): RecipesResponse

    @GET("lookup.php")
    suspend fun getMealById(@Query("i") idMeal: String): RecipeDetailResponse


}