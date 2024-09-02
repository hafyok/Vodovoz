package com.example.vodovoz.Presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun MainScreen(
    viewModel: MainViewModel,
    modifier: Modifier = Modifier
) {
    val categories = viewModel.categories.collectAsState().value
    val prices = mutableListOf<Int>()

    viewModel.items.collectAsState().value.TOVARY.forEach { tovary ->
        tovary.data.forEach { tovaryData ->
            tovaryData.EXTENDEDPRICE.forEach { extendedPrice ->
                extendedPrice.PRICE?.let { prices.add(it) }
            }
        }
    }

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
                TovarItem(price)
                //TovarItem()
            }
        }
    }
}

/*
@Composable
@Preview(showSystemUi = true)
fun PreviewMainScreen() {
    val categories = listOf("Вода", "Кулеры", "Выбор покупателей")
    val prices =
        listOf(640, 360, 2140, 640, 360, 2140, 640, 360, 2140, 640, 360, 2140, 640, 360, 2140)
    MainScreen(categories, prices)
}*/
