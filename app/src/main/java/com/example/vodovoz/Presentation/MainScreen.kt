package com.example.vodovoz.Presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun MainScreen(
    viewModel: MainViewModel,
    modifier: Modifier = Modifier
) {
    val categories = viewModel.categories.collectAsState().value
    val prices = mutableListOf<Int>()
    val selectedCategory = remember { mutableStateOf<String?>(null) }

    viewModel.items.collectAsState().value.TOVARY.forEach { tovary ->
        tovary.data.forEach { tovaryData ->
            tovaryData.EXTENDEDPRICE.forEach { extendedPrice ->
                extendedPrice.PRICE?.let { prices.add(it) }
            }
        }
    }

    Column(modifier = Modifier.padding(vertical = 16.dp)) {
        CategoryChips(
            categories = categories,
            selectedCategory = selectedCategory.value,
            onCategorySelected = { category ->
                selectedCategory.value = category
                //viewModel.loadDataForCategory(category) // передача выбранной категории во ViewModel
            }
        )

        LazyRow(modifier = Modifier.padding(8.dp)) {
            items(prices) { price ->
                //Text(text = price.toString(), Modifier.padding(horizontal = 16.dp))
                TovarItem(price)
                //TovarItem()
            }
        }
    }
}

@Composable
fun CategoryChips(
    categories: List<String>,
    selectedCategory: String?,
    onCategorySelected: (String) -> Unit
) {
    Row {
        categories.forEach { category ->
            val isSelected = category == selectedCategory
            FilterChip(
                selected = isSelected,
                onClick = { onCategorySelected(category) },
                label = {
                    Text(text = category)
                },
                modifier = Modifier.padding(horizontal = 4.dp),
                colors = FilterChipDefaults.filterChipColors(
                        selectedContainerColor = Color.Gray,
                        selectedLabelColor = Color.Black,
                        containerColor = Color.White,
                        labelColor = Color.Black
                    )

            )
        }
    }
}