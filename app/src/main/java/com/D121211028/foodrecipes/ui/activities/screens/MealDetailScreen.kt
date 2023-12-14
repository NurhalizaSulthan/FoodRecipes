@file:JvmName("RecipeDetailScreenKt")

package com.D121211028.foodrecipes.ui.activities.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.D121211028.foodrecipes.ui.activities.HeadingTextComponent
import com.D121211028.foodrecipes.ui.activities.TextTitleMealInfo
import com.D121211028.foodrecipes.ui.activities.recipe_detail.RecipeDetailViewModel
import com.D121211028.foodrecipes.ui.activities.recipe_detail.MealDetailItem
import com.D121211028.foodrecipes.ui.activities.recipe_detail.MealIngredients
import com.D121211028.foodrecipes.ui.activities.recipe_detail.MealInstructions

@Composable
fun MealDetailScreen(
    navController: NavController,
    viewModel: RecipeDetailViewModel = hiltViewModel()
) {

    val state by viewModel.state.collectAsState()

    Box(Modifier.fillMaxSize()) {
        Column(
            Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState()),
        ) {
                HeadingTextComponent(
                    text = "Recipe Details",
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                )

            Card(
                Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFEFB8C8)
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 10.dp
                )
            ) {
                state.meals.firstOrNull()?.let { meal ->
                    MealDetailItem(mealInfo = meal)
                }
                Spacer(modifier = Modifier.height(10.dp))

                TextTitleMealInfo("Ingredients")
                state.meals.firstOrNull()?.let { meal ->
                    MealIngredients(mealInfo = meal)
                }
                Spacer(modifier = Modifier.height(10.dp))

                TextTitleMealInfo("Instructions")
                state.meals.firstOrNull()?.let { meal ->
                    MealInstructions(mealInfo = meal)
                }
            }
        }
        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colorScheme.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp)
                    .align(Alignment.Center)
            )
        }
        if (state.isLoading) {
            CircularProgressIndicator(Modifier.align(Alignment.Center))
        }
    }

}