package com.example.quotes.models

data class Quote(
    // we made this nullable , because it will take care if any value is null
    // its very important
    val text : String ? = null,
    val author : String ? = null
)
