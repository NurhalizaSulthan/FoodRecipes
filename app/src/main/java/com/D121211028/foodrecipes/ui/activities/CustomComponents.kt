package com.D121211028.foodrecipes.ui.activities



import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HeadingTextComponent(
    text: String,
    textAlign: TextAlign,
    modifier: Modifier = Modifier
) {

    Text(
        text = text,
        color = MaterialTheme.colorScheme.onBackground,
        style = MaterialTheme.typography.headlineLarge,
        textAlign = textAlign,
        modifier = modifier
    )

}

@Composable
fun TextTitleMealInfo(text: String) {

    Text(
        text = text,
        color = Color(0xFF000000),
        style = MaterialTheme.typography.titleMedium.copy(fontSize = 25.sp),
        textAlign = TextAlign.Start,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp)
    )

}





