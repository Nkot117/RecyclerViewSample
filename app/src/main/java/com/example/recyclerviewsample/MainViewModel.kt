package com.example.recyclerviewsample

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel : ViewModel() {
    private val _items: MutableStateFlow<List<LinkItemModel>> = MutableStateFlow(emptyList())
    val items = _items.asStateFlow()

    init {
        val linkList = listOf(
            arrayOf("https://www.google.com", "Google"),
            arrayOf("https://www.yahoo.com", "Yahoo"),
            arrayOf("https://www.bing.com", "Bing"),
            arrayOf("https://www.duckduckgo.com", "DuckDuckGo"),
            arrayOf("https://www.ask.com", "Ask"),
            arrayOf("https://www.aol.com", "AOL"),
            arrayOf("https://www.wolframalpha.com", "Wolfram Alpha"),
            arrayOf("https://www.yandex.com", "Yandex"),
            arrayOf("https://www.baidu.com", "Baidu"),
        )

        _items.value = linkList.map {
            LinkItemModel(
                it[1],
                it[0]
            ) {
                printLog("Clicked on ${it[1]}：${it[0]}")
            }
        }
    }

    private fun printLog(message: String) {
        println("MainViewModel: $message")
    }
}