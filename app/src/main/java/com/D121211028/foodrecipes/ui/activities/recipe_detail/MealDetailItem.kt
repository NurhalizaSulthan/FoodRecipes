package com.D121211028.foodrecipes.ui.activities.recipe_detail


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.D121211028.foodrecipes.domain.model.RecipeDetail


@Composable
fun MealDetailItem(
    mealInfo: RecipeDetail
) {

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()


    ) {
        AsyncImage(
            model = mealInfo.strMealThumb,
            contentDescription = "dish-image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .clip(MaterialTheme.shapes.medium)
        )
        }
        Text(
            text = mealInfo.strMeal,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleMedium.copy(
                 fontSize = 28.sp
            ),
            color =  Color(0xFF000000),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 5.dp)
        )

    }


@Composable
fun MealIngredients(
    mealInfo: RecipeDetail
) {
    val ingredients = listOf(
        mealInfo.strIngredient1 to mealInfo.strMeasure1,
        mealInfo.strIngredient2 to mealInfo.strMeasure2,
        mealInfo.strIngredient3 to mealInfo.strMeasure3,
        mealInfo.strIngredient4 to mealInfo.strMeasure4,
        mealInfo.strIngredient5 to mealInfo.strMeasure5,
        mealInfo.strIngredient6 to mealInfo.strMeasure6,
        mealInfo.strIngredient7 to mealInfo.strMeasure7,
        mealInfo.strIngredient8 to mealInfo.strMeasure8,
        mealInfo.strIngredient9 to mealInfo.strMeasure9,
        mealInfo.strIngredient10 to mealInfo.strMeasure10
    )

    Column(
        verticalArrangement = Arrangement.spacedBy(5.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
    ) {
        ingredients.forEach { (ingredient, measure) ->
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "$ingredient - $measure",
                    color = Color(0xFF000000),
                    style = MaterialTheme.typography.bodyLarge,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .padding(start = 10.dp)
                )
            }
        }
    }
}

@Composable
fun MealInstructions(
    mealInfo: RecipeDetail
) {
    val instructions = mealInfo.strInstructions
        .replace("\\r\\n", "\n")
        .replace("\n", "\n\n")
        .trim()
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        contentAlignment = Alignment.TopStart
    ) {
        Text(
            text = instructions,
            textAlign = TextAlign.Justify,
            color = Color(0xFF000000),
            lineHeight = 18.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        )
    }
}