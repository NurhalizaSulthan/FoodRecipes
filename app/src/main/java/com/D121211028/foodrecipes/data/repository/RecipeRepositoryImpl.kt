package com.D121211028.foodrecipes.data.repository

import com.D121211028.foodrecipes.util.Resource
import com.D121211028.foodrecipes.data.remote.RecipeApiService
import com.D121211028.foodrecipes.domain.model.CategoryResponse
import com.D121211028.foodrecipes.domain.model.RecipeDetailResponse
import com.D121211028.foodrecipes.domain.model.RecipesResponse
import com.D121211028.foodrecipes.domain.repository.RecipeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class RecipeRepositoryImpl @Inject constructor(
    private val api: RecipeApiService
) : RecipeRepository {

    override suspend fun getCategories(): Flow<Resource<CategoryResponse>> = flow {
        try {
            emit(Resource.Loading())
            val categories = api.getCategories()
            emit(Resource.Success(categories))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "Terjadi kesalahan yang tidak terduga"))
        } catch (e: IOException) {
            emit(Resource.Error("Tidak dapat terhubung ke server. Periksa koneksi internet Anda"))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "Terjadi kesalahan yang tidak terduga"))
        }
    }

    override suspend fun getMealsByCategory(strCategory: String): Flow<Resource<RecipesResponse>> = flow {
        try {
            emit(Resource.Loading())
            val meals = api.getMealsByCategory(strCategory)
            emit(Resource.Success(meals))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "Terjadi kesalahan yang tidak terduga"))
        } catch (e: IOException) {
            emit(Resource.Error("Tidak dapat terhubung ke server. Periksa koneksi internet Anda"))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "Terjadi kesalahan yang tidak terduga"))
        }
    }

    override suspend fun getMealById(idMeal: String): Flow<Resource<RecipeDetailResponse>> = flow {
        try {
            emit(Resource.Loading())
            val meals = api.getMealById(idMeal)
            emit(Resource.Success(meals))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "Terjadi kesalahan yang tidak terduga"))
        } catch (e: IOException) {
            emit(Resource.Error("Tidak dapat terhubung ke server. Periksa koneksi internet Anda"))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "Terjadi kesalahan yang tidak terduga"))
        }
    }
}
