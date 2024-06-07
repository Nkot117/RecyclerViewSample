package com.example.recyclerviewsample

data class ListItemModel(
    val title: String,
    val url: String,
    val clickAction: () -> Unit
)