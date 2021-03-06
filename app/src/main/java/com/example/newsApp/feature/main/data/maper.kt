package com.example.newsApp.feature.main.data

import com.example.newsApp.feature.main.data.model.ArticleModel
import com.example.newsApp.feature.main.data.model.TopNewsModel
import com.example.newsApp.feature.main.domain.model.ArticleDomainModel
import com.example.newsApp.feature.main.domain.model.TopNewsDomainModel

fun TopNewsModel.toDomain(): TopNewsDomainModel {
    return TopNewsDomainModel(
        status = "0",
        totalResults = 0,
        articles = this.articles?.map { articleModel ->
            articleModel.toDomain()
        }
    )
}

fun ArticleModel.toDomain(): ArticleDomainModel {
    return ArticleDomainModel(
        author = this.author,
        title = this.title,
        description = this.description,
        url = this.url,
        urlToImage = this.urlToImage,
        publishedAt = this.publishedAt,
        content = this.content
    )
}