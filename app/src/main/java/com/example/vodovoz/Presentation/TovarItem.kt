package com.example.vodovoz.Presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.vodovoz.R

@Composable
fun TovarItem(tovary: Pair<Int, String?>) {
    Column(modifier = Modifier.padding(8.dp)) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
            Image(
                painter = painterResource(id = R.drawable.baseline_favorite_border_24),
                contentDescription = null,
                //alignment = Alignment.End,
                modifier = Modifier.size(24.dp)
            )
        }
        Row {
            AsyncImage(
                model = "https://szorin.vodovoz.ru" + tovary.second,
                contentDescription = null,
                modifier = Modifier.size(150.dp)
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Absolute.SpaceBetween
        ) {
            Text(text = tovary.first.toString() + " P")

            Spacer(modifier = Modifier.width(56.dp))

            Image(
                painter = painterResource(id = R.drawable.baseline_shopping_basket_24),
                contentDescription = null,
                modifier = Modifier
                    .size(24.dp)

            )
        }
    }
}
