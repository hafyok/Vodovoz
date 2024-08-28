package com.example.vodovoz

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun MainScreen(categories: List<String>, prices: List<Int>, modifier: Modifier = Modifier) {
    Column(modifier = Modifier.padding(vertical = 16.dp)) {
        LazyRow(modifier = Modifier.padding(8.dp)) {
            items(categories) { category ->
                Text(text = category, modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .clickable(
                        onClick = {
                            //TODO()
                        }
                    ))
            }
        }
        LazyRow(modifier = Modifier.padding(8.dp)) {
            items(prices) { price ->
                //Text(text = price.toString(), Modifier.padding(horizontal = 16.dp))
                TovarItem()
                //TovarItem()
            }
        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun PreviewMainScreen() {
    val categories = listOf("Вода", "Кулеры", "Выбор покупателей")
    val prices =
        listOf(640, 360, 2140, 640, 360, 2140, 640, 360, 2140, 640, 360, 2140, 640, 360, 2140)
    MainScreen(categories, prices)
}