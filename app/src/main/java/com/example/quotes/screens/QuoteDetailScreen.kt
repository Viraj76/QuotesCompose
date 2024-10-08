package com.example.quotes.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FormatQuote
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quotes.DataManager
import com.example.quotes.models.Quote


@Composable
fun QuoteDetail(quote: Quote) {
    BackHandler {
        DataManager.switchPages(null)
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize(1f)
            .background(
                Brush.sweepGradient(
                    colors = listOf(
                        Color(0xFFffffff),
                        Color(0xFFE3E3E3)
                    )
                )
            )
    ) {
        Card(
            elevation = CardDefaults.cardElevation(defaultElevation = 7.dp),
            modifier = Modifier.padding(20.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(10.dp, 20.dp)
            ) {
                Image(
                    imageVector = Icons.Outlined.FormatQuote,
                    contentDescription = "",
                    modifier = Modifier
                        .size(40.dp)
                        .rotate(180f)
                        .background(Color.Black),
                    colorFilter = ColorFilter.tint(Color.White)

                )
                quote.text?.let {
                    Text(
                        text = it,
                        style = MaterialTheme.typography.bodyLarge,
                        fontSize = 23.sp
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                quote.author?.let {
                    Text(
                        text = it,
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
        }
    }
}