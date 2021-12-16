package com.example.newsApp.feature.main.data.api

import com.example.newsApp.feature.main.domain.model.ArticleDomainModel

interface NewsRepository {

    suspend fun getTopNews(): List<ArticleDomainModel>
}