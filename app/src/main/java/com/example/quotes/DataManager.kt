package com.example.quotes

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.example.quotes.models.Quote
import com.google.gson.Gson

object DataManager {
     var quotesData = emptyArray<Quote>()
    var isDataLoaded = mutableStateOf(false)
    fun loadAssetsFromFile(context: Context) {
        val inputStream = context.assets.open( "quotes.json")
        val size: Int = inputStream.available()
        val buffer = ByteArray (size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String (buffer, Charsets. UTF_8)
        val gson = Gson()
        quotesData = gson.fromJson (json, Array<Quote>::class.java)
        isDataLoaded.value = true
    }
}