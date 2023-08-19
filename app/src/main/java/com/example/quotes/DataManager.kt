package com.example.quotes

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.example.quotes.models.Quote
import com.google.gson.Gson

object DataManager {
     var quotesData = emptyArray<Quote>()
    var isDataLoaded = mutableStateOf(false)
    var currentPage = mutableStateOf(Page.LISTING)
    var currentQuote : Quote? = null

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

    fun switchPages(quote: Quote?){
        if(currentPage.value == Page.LISTING){
            currentQuote = quote
            currentPage.value = Page.DETAIL
        }
        else{
            currentPage.value = Page.LISTING
        }
    }
}

