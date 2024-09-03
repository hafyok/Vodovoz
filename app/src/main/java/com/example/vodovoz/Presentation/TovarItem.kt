package com.example.vodovoz.Presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.vodovoz.R

@Composable
fun TovarItem(tovary: Pair<Int, String?>) {
    Column(modifier = Modifier.padding(8.dp)) {
        Row() {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = null,
                alignment = Alignment.CenterEnd,
                modifier = Modifier.size(50.dp)
            )
        }
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = null
        )
        Row(/*modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End*/) {
            Text(text = tovary.first.toString())
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = null,
                modifier = Modifier.size(50.dp)
            )
        }
    }
}