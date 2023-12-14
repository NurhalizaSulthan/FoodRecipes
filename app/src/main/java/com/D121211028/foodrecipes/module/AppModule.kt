package com.D121211028.foodrecipes.module

import com.D121211028.foodrecipes.data.remote.RecipeApiService
import com.D121211028.foodrecipes.data.repository.RecipeRepositoryImpl
import com.D121211028.foodrecipes.domain.repository.RecipeRepository
import com.D121211028.foodrecipes.domain.use_case.ApiUseCases
import com.D121211028.foodrecipes.domain.use_case.GetCategoriesUseCase
import com.D121211028.foodrecipes.domain.use_case.GetRecipeUseCase
import com.D121211028.foodrecipes.domain.use_case.GetRecipesUseCase
import com.D121211028.foodrecipes.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule{

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun providesMealService(retrofit: Retrofit): RecipeApiService {
        return retrofit.create(RecipeApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideMealRepository(api: RecipeApiService): RecipeRepository {
        return RecipeRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideApiUseCases(repository: RecipeRepository): ApiUseCases {
        return ApiUseCases(
            getCategoriesUseCase = GetCategoriesUseCase(repository),
            getMealsUseCase = GetRecipesUseCase(repository),
            getMealUseCase = GetRecipeUseCase(repository)
        )
    }
}