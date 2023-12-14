package com.D121211028.foodrecipes.ui.activities.navigation


import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.D121211028.foodrecipes.ui.activities.screens.CategoriesScreen
import com.D121211028.foodrecipes.ui.activities.screens.MealDetailScreen
import com.D121211028.foodrecipes.ui.activities.screens.MealsScreen


@Composable
fun FoodRecipeNav() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.CategoriesScreen.route
    ) {

        // Categories Screen
        composable(
            route = Screen.CategoriesScreen.route
        ) {
            CategoriesScreen(
                navController = navController,
                onCategoryClick = { strCategory ->
                    navController.navigate("${Screen.MealsScreen.route}/${strCategory}")
                }
            )
        }

        // Meals Screen
        composable(
            route = "${Screen.MealsScreen.route}/{strCategory}",
            arguments = listOf(navArgument("strCategory") { type = NavType.StringType })
        ) { navBackStackEntry ->
            navBackStackEntry.arguments?.getString("strCategory")?.let {
                MealsScreen(
                    navController = navController,
                    onMealItemClick = { idMeal ->
                        navController.navigate("${Screen.MealDetailScreen.route}/${idMeal}")
                    }
                )
            }
        }

        // Meal Detail Screen
        composable(
            route = "${Screen.MealDetailScreen.route}/{idMeal}",
            arguments = listOf(navArgument("idMeal") { type = NavType.StringType })
        ) { navBackStackEntry ->
            navBackStackEntry.arguments?.getString("idMeal")?.let {
                MealDetailScreen(navController = navController)
            }
        }
    }
}
