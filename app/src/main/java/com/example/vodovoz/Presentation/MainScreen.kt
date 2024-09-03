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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun MainScreen(
    viewModel: MainViewModel,
    modifier: Modifier = Modifier
) {
    val categories = viewModel.categories.collectAsState().value
    val selectedCategory = remember { mutableStateOf<String?>(null) }
    var tovar by remember { mutableStateOf(viewModel.getTovar("Выбор покупателей")) }

    Column(modifier = Modifier.padding(vertical = 16.dp)) {
        // Категории
        CategoryChips(
            categories = categories,
            selectedCategory = selectedCategory.value,
            onCategorySelected = { category ->
                selectedCategory.value = category
                tovar = viewModel.getTovar(category)
            }
        )

        LazyRow(modifier = Modifier.padding(8.dp)) {
            items(tovar) { t ->
                TovarItem(t)
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