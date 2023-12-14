package com.D121211028.foodrecipes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.D121211028.foodrecipes.ui.activities.navigation.FoodRecipeNav
import com.D121211028.foodrecipes.ui.theme.FoodRecipesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodRecipesTheme {
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    FoodRecipesApp()
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun FoodRecipesApp() {
    FoodRecipeNav()
}
