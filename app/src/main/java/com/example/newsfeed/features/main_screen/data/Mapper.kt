package com.example.newsfeed.features.main_screen.data

import com.example.newsfeed.features.main_screen.data.api.model.ArticleModel
import com.example.newsfeed.features.main_screen.domain.model.ArticleDomainModel

fun ArticleModel.toDomain() = ArticleDomainModel(
    author = this.author ,
    title = this.title ?: "null",
    description = this.description ,
    url = this.url,
    publishedAt = publishedAt ?: "null"


    )