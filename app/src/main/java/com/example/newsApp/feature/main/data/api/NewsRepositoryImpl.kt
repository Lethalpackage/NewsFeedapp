package com.example.newsApp.feature.main.data.api

import com.example.newsApp.feature.main.data.toDomain
import com.example.newsApp.feature.main.domain.model.ArticleDomainModel

class NewsRepositoryImpl(
    private val newsRemoteSource: NewsRemoteSource
) : NewsRepository {

    override suspend fun getTopNews(): List<ArticleDomainModel> {
        return newsRemoteSource.getTopNews().toDomain().articles
    }
}