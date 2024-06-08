package com.example.recyclerviewsample

data class LinkItemModel(
    val title: String,
    val url: String,
    val clickAction: () -> Unit
)