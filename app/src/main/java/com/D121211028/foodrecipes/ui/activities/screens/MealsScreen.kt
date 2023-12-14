package com.D121211028.foodrecipes.ui.activities.screens


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.D121211028.foodrecipes.ui.activities.HeadingTextComponent
import com.D121211028.foodrecipes.ui.activities.recipe_list.RecipesListViewModel
import com.D121211028.foodrecipes.ui.activities.recipe_list.SingleMealItem

@Composable
fun MealsScreen(
    onMealItemClick: (String) -> Unit,
    navController: NavController,
    viewModel: RecipesListViewModel = hiltViewModel()
) {

    val state by viewModel.state.collectAsState()

    Box(Modifier.fillMaxSize()){
        Column(Modifier.fillMaxWidth()) {
                HeadingTextComponent(
                    text = "Recipe List",
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                )

            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(10.dp)
            ) {
                items(state.meals) { dishes ->
                    SingleMealItem(
                        mealsItem = dishes,
                        onMealItemClick = onMealItemClick
                    )
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
                    .align(Alignment.Center)
            )
        }
        if (state.isLoading) {
            CircularProgressIndicator(Modifier.align(Alignment.Center))
        }
    }

}