package com.D121211028.foodrecipes.ui.activities.navigation

sealed class Screen(val route: String) {

    object CategoriesScreen: Screen("categories_screen")
    object MealsScreen: Screen("meals_screen")
    object MealDetailScreen: Screen("meal_detail_screen")

}