package com.example.newsfeed.features.main_screen.domain.model

data class ArticleDomainModel(
    val author: String?,
    val title: String,
    val description: String?,
    val url: String,
    val publishedAt: String
)
