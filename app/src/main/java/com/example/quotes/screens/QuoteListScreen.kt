package com.example.quotes.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quotes.models.Quote

@Composable
fun QuoteListScreen(data : Array<Quote> , onClick : () -> Unit){
    Column {
        Text(
            textAlign = TextAlign.Center,
            text = "Quotes App",
            modifier = Modifier
                .fillMaxWidth(1f)
                .padding(8.dp, 24.dp)
                ,
            style = MaterialTheme.typography.labelLarge,
            fontSize = 30.sp
        )
        QuoteList(data = data) {
            onClick()
        }
    }
}